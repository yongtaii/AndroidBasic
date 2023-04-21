package com.jworld.core.data.user.model

data class UsersData(
    val userList: List<User>,
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int
)

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
    val avatarImg: String,
)