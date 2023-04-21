package com.jworld.network.reqres.datasource

import com.jworld.network.reqres.model.User
import com.jworld.network.reqres.model.UsersResponse
import retrofit2.Response

interface ReqresDataSource {
    suspend fun getUsers(): Response<UsersResponse>
}