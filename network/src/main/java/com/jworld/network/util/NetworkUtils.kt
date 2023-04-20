package com.jworld.network.util

import com.jworld.network.common.CommonError
import com.jworld.network.common.data.NetworkResponse
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.net.HttpURLConnection


/**
 * 네트워크 유틸 클래스
 */
object NetworkUtils {

    @JvmStatic
    @Throws(Exception::class)
    fun throwUnAuthorizedExceptionIfNeed(response: Response<*>?) {
        val responseCode = response?.code() ?: return
        if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
            throw HttpException(Response.error<Any>(HttpURLConnection.HTTP_UNAUTHORIZED, "HTTP_UNAUTHORIZED".toResponseBody("text/plain".toMediaTypeOrNull())))
        }
    }

    // 기본 제공 Intercepter
    @JvmStatic
    fun getIntercepter(sessionOptions: SessionOptions): Interceptor {
        return Interceptor { chain ->
            val url = sessionOptions.sessionUrl
            val original = chain.request()
            if (url.isEmpty()) {
                return@Interceptor chain.proceed(original)
            }

            val originalPath = original.url.encodedPath
            val originalQuery = original.url.encodedQuery

            val stringBuilder = StringBuilder(url)
            stringBuilder.append(originalPath)
            if (!originalQuery.isNullOrEmpty()) {
                stringBuilder.append("?").append(originalQuery)
            }

            val request = with(original.newBuilder()) {
                url(stringBuilder.toString())
                sessionOptions.getHeader().forEach {
                    addHeader(it.key, it.value)
                }
                build()
            }

            chain.proceed(request)
        }
    }

    @JvmStatic
    fun getTokenInterceptor(sessionOptions: SessionOptions): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()

//            if(sessionOptions.lpToken?.isValid() == false && !request.url.encodedPath.contains("/token")) { //token을 사용하는 세션인데 토큰이 valid하지 않다. -> refresh 해줘야 한다.
//                NetworkManager.getInstance().refreshToken()
//            }
            chain.proceed(request)
        }
    }

    /**
     * 401 인증에러 인지 확인하는 메서드
     * */
    @JvmStatic
    fun isUnauthorized(throwable : Throwable?) : Boolean {

        val isThrowable = throwable?.let {
            return if (throwable is HttpException) {
                throwable.response()?.code() == 401
            } else {
                false
            }
        }

        return isThrowable ?: false
    }

    /**
     * 네트워크 에러 에러 처리
     * */
    fun receiveCargoDetail(response: retrofit2.Response<CargoDetailResponse>?): NetworkResponse {
        if (response == null) {
            return NetworkResponse ( NetworkConstants.RESULT_FAIL_CODE, CommonError.CODE_ERROR_UNKNOWN )
        }

        return when (response.code()) {
            HttpURLConnection.HTTP_OK -> processReceiveResult(response)
            else -> {
                NetworkResponse(code = NetworkConstants.RESULT_FAIL_CODE, message = CommonError.CODE_ERROR_UNKNOWN)
            }
        }
    }

    private fun processReceiveResult(response: retrofit2.Response<T>?): NetworkResponse {
        val cargoDetailResponse = response?.body()

        if (cargoDetailResponse?.isValid() != true) {
            return NetworkResponse(NetworkConstants.RESULT_FAIL_CODE, CommonError.CODE_EMPTY_DATA)
        }
        return NetworkResponse(NetworkConstants.RESULT_SUCCESS_RECEIVE_DATA, message = response?.code().toString(), result = cargoDetailResponse)
    }
}