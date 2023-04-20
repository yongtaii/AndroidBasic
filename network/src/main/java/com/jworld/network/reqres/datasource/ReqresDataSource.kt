package com.jworld.network.reqres.datasource

import com.jworld.network.reqres.model.User

interface ReqresDataSource {
    suspend fun getUsers(): List<User>
}