package com.jworld.core.data.user.repository

import com.jworld.core.data.common.RepoResponse
import com.jworld.core.data.user.model.User

class FakeUserRepository() : UserRepository {

//    override suspend fun getUserList() : List<User> = emptyList()
    override suspend fun getUserList() : RepoResponse = RepoResponse()

}