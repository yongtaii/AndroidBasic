package com.jworld.core.data.user.repository

import com.jworld.core.data.user.model.User

interface UserRepository {
    suspend fun getUserList() : List<User>
}