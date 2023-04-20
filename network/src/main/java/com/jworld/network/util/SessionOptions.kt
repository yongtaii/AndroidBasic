package com.jworld.network.util

import okhttp3.Interceptor


/**
 * 세션 클래스
 * 생성만 해주면 얘를 통해서 네트워크 생성이 가능합니다.
 */
class SessionOptions(
    /**
     * 세션 URL
     * 입력값이 없으면 기본적으로다가 넣어주자.
     */
    val sessionUrl: String = "",
    /**
     * proxyUrl
     */
    val proxyUrl: String = "",
    /**
     * Session Type
     */
    val sessionType: SessionType = SessionType.UNKNOWN,
//    /**
//     * GeoMasterKey
//     */
//    val geomasterKey: String = "",
//    /**
//     * lpToken
//     */
//    val lpToken: LpToken? = null
) {
    /**
     * Retrofit 객체 생성을 위한 Intercepter 반환
     */
    fun getInterceptor(): Interceptor {
        return NetworkUtils.getIntercepter(this)
    }

    /**
     * Retrofit 생성 시 토큰 리프레시용 interceptor 반환
     */
    fun getTokenInterceptor(): Interceptor {
        return NetworkUtils.getTokenInterceptor(this)
    }

    fun getHeader(): Map<String, String> {
        return when (sessionType) {
            SessionType.UNKNOWN -> emptyMap()
            SessionType.GW -> emptyMap()
            SessionType.ACCOUNT -> HashMap<String, String>().apply {
                put(NetworkConstants.KEY_HOST, proxyUrl)
            }
            SessionType.REQRES -> HashMap<String, String>().apply {
            }
//            SessionType.GW -> HashMap<String, String>().apply {
////                put(NetworkConstants.KEY_API_KEY, tokenId)
//                put(NetworkConstants.KEY_AUTHORIZATION, "Bearer %s".format(lpToken?.apiKey))
//                put(NetworkConstants.KEY_HOST, proxyUrl)
//            }
//            SessionType.GEOMASTER -> HashMap<String, String>().apply {
//                put(NetworkConstants.KEY_AUTHORIZATION, "Bearer %s".format(geomasterKey))
//            }
//            SessionType.PROD -> HashMap<String, String>().apply {
//                put(NetworkConstants.KEY_AUTHORIZATION, "Bearer %s".format(lpToken?.apiKey))
//            }
//            SessionType.PROD_ACCOUNT -> HashMap<String, String>().apply {
//            }
        }
    }

    companion object {

        /**
         * REQRES 서버
         * */
        private const val REQRES_BASE_URL = "https://reqres.in"

        /**
         * EPC 공통
         * */
        private const val EPC_GW_BASE_URL = "https://211.253.29.206"
        private const val EPC_ACCOUNT_BASE_URL = "https://211.253.29.206"


//        /**
//         * API GW 서버 변경 시 선택.
//         * TyTDomainType.IPC_PROD : IPC 상용 서버
//         * DomainType.IPC_TB : IPC 테스트 서버
//         * DomainType.EPC_GW : EPC 서버
//         * */
    private var GW_SERVER_URL = ServerDomain.REQRES
//        private var GW_SERVER_URL = when(BuildConfig.FLAVOR){
//            "prod" -> DomainType.IPC_PROD
//            "epcStage" -> DomainType.EPC_STAGE
//            "epcDev" -> DomainType.EPC_DEV
//            else -> DomainType.IPC_PROD
//        }


//        /**
//         * 로그인 처리용 세션 데이터 반환
//         */
//        fun createAccountSession(): SessionOptions {
//            return when(GW_SERVER_URL){
//                DomainType.EPC_STAGE -> SessionOptions(sessionUrl = EPC_ACCOUNT_BASE_URL, proxyUrl = EPC_STAGE_ACCOUNT_HOST_HEADER, sessionType = SessionType.ACCOUNT)
//                DomainType.EPC_DEV -> SessionOptions(sessionUrl = EPC_ACCOUNT_BASE_URL, proxyUrl = EPC_DEV_ACCOUNT_HOST_HEADER, sessionType = SessionType.ACCOUNT)
//                DomainType.IPC_PROD -> SessionOptions(sessionUrl = PROD_BASE_URL, sessionType = SessionType.PROD_ACCOUNT)
//                else -> SessionOptions(sessionUrl = PROD_BASE_URL, sessionType = SessionType.PROD_ACCOUNT)
//            }
//        }

        @JvmStatic
        fun createGWSession(lpToken: String): SessionOptions {
            return when(GW_SERVER_URL){
                ServerDomain.REQRES -> SessionOptions(sessionUrl = REQRES_BASE_URL, sessionType = SessionType.REQRES)
//                ServerDomain.EPC_DEV -> SessionOptions(sessionUrl = EPC_GW_BASE_URL, proxyUrl = EPC_DEV_GW_HOST_HEADER, sessionType = SessionType.GW, lpToken = lpToken)
//                ServerDomain.IPC_PROD -> SessionOptions(sessionUrl = PROD_BASE_URL, sessionType = SessionType.PROD, lpToken = lpToken)
                else -> SessionOptions(sessionUrl = REQRES_BASE_URL, sessionType = SessionType.REQRES)
            }
        }

//        /**
//         * 지오마스터 세션 데이터 반환
//         */
//        @JvmStatic
//        fun createGeomasterSession(key: String): SessionOptions {
//            return SessionOptions(sessionUrl = GEOMASTER_BASE_URL, geomasterKey = key, sessionType = SessionType.GEOMASTER)
//        }


    }
}

/**
 *
 * SessionType
 */
enum class SessionType {
    /**
     * 디폴트 설정 - 미설정시 아무것도 하지 말아라...
     */
    UNKNOWN,
    /**
     * 로그인 시 사용
     */
    ACCOUNT,
    /**
     * 인증 이후 사용
     */
    GW,

    /**
     * REQRES
     */
    REQRES,
}

enum class ServerDomain {
    REQRES,
    IPC_PROD,
    IPC_TB,
    EPC_STAGE,
    EPC_DEV,
}