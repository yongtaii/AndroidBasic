package com.jworld.network.reqres.provider

data class UsersData(
    val userList: List<UserData>,
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int
)

data class UserData(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
    val avatarImg: String,
)