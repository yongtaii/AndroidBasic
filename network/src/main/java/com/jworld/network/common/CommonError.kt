package com.jworld.network.common

import java.net.HttpURLConnection

object CommonError {

    /** request 요청 오류중에 확인되지 않은 오류 */
    const val CODE_ERROR_UNKNOWN = "S0999"

    /** 검색 결과가 없는 경우 */
    const val CODE_EMPTY_DATA = "S0980"

    /** 내부 에러인 경우 */
    const val CODE_INTERNAL_ERROR = "S0999"

    /** 네트워크 에러인 경우 */
    const val CODE_NETWORK_ERROR = "S0997"

    /** 내부 에러인 경우 */
    const val CODE_INVALID_KEY_ERROR = "S0996"

    /** 네트워크 에러인 경우 */
    const val CODE_INVALID_REQUEST_ERROR = "S0995"

    /** 400 에러인 경우 */
    const val CODE_HTTP_BAD_REQUEST_ERROR = "S0001"

    /** 403 에러인 경우 */
    const val CODE_HTTP_FORBIDDEN_ERROR = "S0002"

    /** 404 에러인 경우 */
    const val CODE_HTTP_NOT_FOUND_ERROR = "S0003"

    /** 406 에러인 경우 */
    const val CODE_HTTP_NOT_ACCEPTABLE_ERROR = "S0004"

    /** 415 에러인 경우 */
    const val CODE_HTTP_UNSUPPORTED_TYPE_ERROR = "S0005"

    /** 500 에러인 경우 */
    const val CODE_HTTP_INTERNAL_ERROR = "S0006"

    /** 403 에러인 경우 */
    const val CODE_INVALID_KEYWORD_LENGTH_ERROR = "S0009"

    /**
     * 통신 혹은 기타 발생된 에러에 대한 변환 코드를 반환한다.
     */
    @JvmStatic
    fun getErrorCode(code: Int) : String {
        return when (code) {
            NetworkConstants.EMPTY_DATA -> CODE_EMPTY_DATA
            NetworkConstants.INTERNAL_ERROR -> CODE_INTERNAL_ERROR
            NetworkConstants.NETWORK_ERROR -> CODE_NETWORK_ERROR
            NetworkConstants.INVALID_KEY_ERROR -> CODE_INVALID_KEY_ERROR
            NetworkConstants.INVALID_REQUEST_ERROR -> CODE_INVALID_REQUEST_ERROR
            HttpURLConnection.HTTP_BAD_REQUEST -> CODE_HTTP_BAD_REQUEST_ERROR
            HttpURLConnection.HTTP_FORBIDDEN -> CODE_HTTP_FORBIDDEN_ERROR
            HttpURLConnection.HTTP_NOT_FOUND -> CODE_HTTP_NOT_FOUND_ERROR
            HttpURLConnection.HTTP_NOT_ACCEPTABLE -> CODE_HTTP_NOT_ACCEPTABLE_ERROR
            HttpURLConnection.HTTP_UNSUPPORTED_TYPE -> CODE_HTTP_UNSUPPORTED_TYPE_ERROR
            HttpURLConnection.HTTP_INTERNAL_ERROR -> CODE_HTTP_INTERNAL_ERROR
            NetworkConstants.INVALID_KEYWORD_LENGTH_ERROR -> CODE_INVALID_KEYWORD_LENGTH_ERROR
            else -> CODE_ERROR_UNKNOWN
        }
    }
}
