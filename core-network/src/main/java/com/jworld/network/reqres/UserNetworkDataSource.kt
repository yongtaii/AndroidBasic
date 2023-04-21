package com.jworld.network.reqres

import com.jworld.network.common.data.NetworkResponse
import com.jworld.network.reqres.api.ReqresApiService
import com.jworld.network.util.NetworkApiCreator
import com.jworld.network.util.NetworkUtils
import com.jworld.network.util.SessionOptions
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserNetworkDataSource @Inject constructor() {

    private val reqresApiService : ReqresApiService

    init {
        val token = ""
        val sessionOptions = SessionOptions.createGWSession(token)
        val retrofit = NetworkApiCreator.createRetrofitByObservable(sessionOptions, isDebug = true)
        reqresApiService = retrofit.create(ReqresApiService::class.java)
    }

    /**
     * 사용자 정보 가져오기
     * */
    suspend fun getUsers(): NetworkResponse = reqresApiService.getUsers().run { NetworkUtils.processApiResponseError(this) }
//
//    /**
//     * 외부 데이터 모델로 변환
//     * */
//    private suspend fun convertUsersData(data: NetworkResponse): NetworkResponse {
//        if (data.code != NetworkConstants.RESULT_SUCCESS_RECEIVE_DATA) return data
//        data.result = (data.result as UsersResponse)::toExternal
//        return data
//    }

}