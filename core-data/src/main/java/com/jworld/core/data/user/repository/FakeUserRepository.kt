package com.jworld.core.data.user.repository

import com.jworld.core.data.user.model.User

class FakeUserRepository() : UserRepository {

    override suspend fun getUserList() : List<User> = emptyList()

}