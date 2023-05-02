package com.jworld.core.data.common

import com.jworld.network.common.CommonError

data class RepoResponse(
    var isSuccess : Boolean = false,
    var errorCode: Int = RepoCommonError.ERROR_CODE_DEFAULT,
    val errorMsg: String = RepoCommonError.ERROR_MESSAGE_DEFAULT,
    var result: Any? = null
)

object RepoCommonError {

    /** 기본 에러 코드 */
    const val ERROR_CODE_DEFAULT= -1
    /** 기본 에러 메시지 */
    const val ERROR_MESSAGE_DEFAULT = "정보를 불러오는데 실패했습니다."
}