package com.jworld.network.reqres.datasource

import android.util.Log
import com.jworld.network.common.data.NetworkResponse
import com.jworld.network.reqres.api.ReqresApiService
import com.jworld.network.reqres.model.User
import com.jworld.network.reqres.model.UsersResponse
import com.jworld.network.reqres.model.asExternalModel
import com.jworld.network.reqres.provider.UserData
import com.jworld.network.util.NetworkApiCreator
import com.jworld.network.util.NetworkUtils
import com.jworld.network.util.SessionOptions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.Response

class ReqresNetworkDataSource : ReqresDataSource{

    private val reqresApiService : ReqresApiService

    init {
        val token = ""
        val sessionOptions = SessionOptions.createGWSession(token)
        val retrofit = NetworkApiCreator.createRetrofitByObservable(sessionOptions, isDebug = true)
        reqresApiService = retrofit.create(ReqresApiService::class.java)
    }

    suspend fun getUsers2() : NetworkResponse {

        val apiResponse = reqresApiService.getUsers()
//        val result1 = NetworkUtils.throwUnAuthorizedExceptionIfNeed(apiResponse)
        val result2 = NetworkUtils.processApiResponseError(apiResponse)
        val data = result2.result as UsersResponse
        result2.result = data::asExternalModel
        return result2

    }

//    override suspend fun getUsers(): List<User> = reqresApiService.getUsers().body() ?: emptyList()
    override suspend fun getUsers(): Response<UsersResponse> = reqresApiService.getUsers()
}