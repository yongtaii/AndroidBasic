package com.jworld.core.data.user.repository

import com.jworld.core.data.user.model.User
import com.jworld.network.reqres.datasource.UserNetworkDataSource

class NetworkUserRepository (
    private val userNetworkDataSource : UserNetworkDataSource,
) : UserRepository {

    override suspend fun getUserList() : List<User> {
        return emptyList()
    }

}