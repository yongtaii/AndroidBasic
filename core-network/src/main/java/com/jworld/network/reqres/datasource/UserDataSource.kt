package com.jworld.network.reqres.datasource

import com.jworld.network.common.data.NetworkResponse

interface UserDataSource {
    suspend fun getUsers(): NetworkResponse
}