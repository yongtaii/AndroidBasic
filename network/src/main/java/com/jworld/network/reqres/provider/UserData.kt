package com.jworld.network.reqres.provider

import com.jworld.network.reqres.model.Support
import com.jworld.network.reqres.model.User
import com.jworld.network.reqres.model.UsersResponse
import com.jworld.network.reqres.model.asExternalModel

data class UsersData(
    val userList: List<UserData>,
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int
)

fun UsersData.convert(usersResponse : UsersResponse) = UsersData(
    userList = usersResponse.data.map { it.asExternalModel() },
    page = usersResponse.page,
    perPage = usersResponse.per_page,
    total = usersResponse.total,
    totalPages = usersResponse.total_pages,
)

data class UserData(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
    val avatarImg: String,
)