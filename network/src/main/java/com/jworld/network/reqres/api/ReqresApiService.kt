package com.jworld.network.reqres.api

import com.jworld.network.common.data.NetworkResponse
import com.jworld.network.reqres.model.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface ReqresApiService {

    companion object {
        private const val BASE_URL = "api"
        private const val USERS = "$BASE_URL/users"
    }

    @GET(USERS)
    suspend fun getUsers(): Response<List<User>>



}