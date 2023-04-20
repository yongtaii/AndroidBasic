package com.jworld.network.reqres.datasource

import com.jworld.network.reqres.api.ReqresApiService
import com.jworld.network.reqres.model.User
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

    override suspend fun getUsers(): Flow<List<User>> {
        return flow {
            emit(reqresApiService.getUsers())
        }.map {
//            NetworkUtils.throwUnAuthorizedExceptionIfNeed(it)
            OrderResponse.CargoDetail.receiveCargoDetail(it)
        }.map {
            convertCargoDetailData(it)
        }


    }

//    override suspend fun getUsers(): List<User> = reqresApiService.getUsers().data
}