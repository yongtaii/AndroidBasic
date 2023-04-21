package com.jworld.core.data.user.repository

import com.jworld.core.data.user.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    val myModels: Flow<List<User>>

    suspend fun getUserList() : List<User>
}