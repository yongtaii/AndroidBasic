package com.jworld.network.util

object NetworkConstants {

    const val RESULT_FAIL_CODE: Int = 0
    const val RESULT_SUCCESS_RECEIVE_DATA: Int = 20

    const val KEY_AUTHORIZATION = "Authorization"
    const val KEY_API_KEY = "apiKey"
    const val KEY_HOST = "host"
    const val KEY_TEST_CUSTOM_ID = "X-Consumer-Custom-Id"
    const val KEY_TEST_AUTH_SCOPE = "X-Authenticated-Scope"

    // Error Code
    const val INTERNAL_ERROR = 999
    const val UNKNOWN_ERROR_MESSAGE = "unknown error"

    const val TIMEOUT_ERROR = 998
    const val TIMEOUT_ERROR_MESSAGE = "timeout error"

    const val NETWORK_ERROR = 997
    const val NETWORK_ERROR_MESSAGE = "network error"

    const val INVALID_KEY_ERROR = 996
    const val INVALID_KEY_MESSAGE = "invalid key"

    const val INVALID_REQUEST_ERROR = 995
    const val IINVALID_REQUEST_ERROR_MESSAGE = "invalid request data"

    const val NETWORK_NOT_INITIALIZE_ERROR = 990
    const val NETWORK_NOT_INITIALIZE_MESSAGE = "network is not initialize"

    const val EMPTY_DATA = 980
    const val EMPTY_DATA_MESSAGE = "no data"

    const val INVALID_KEYWORD_LENGTH_ERROR = 899
    const val INVALID_KEYWORD_LENGTH_MESSAGE = "invalid keyword length"

    //-- 이하 error code의 경우 http error

    /**
     * retry count
     * 1회만 retry
     */
    const val RETRY_COUNT = 1
}