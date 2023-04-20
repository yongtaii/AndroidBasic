package com.jworld.network.common.data

import com.jworld.network.common.CommonError

data class NetworkResponse(val code: Int, val message: String = CommonError.CODE_ERROR_UNKNOWN, var result: Any? = null)
