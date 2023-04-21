package com.jworld.network.reqres.model

import com.jworld.network.common.data.ApiResponse
import com.jworld.network.reqres.provider.UserData
import com.jworld.network.reqres.provider.UsersData
import kotlinx.serialization.Serializable


@Serializable
data class UsersResponse(
    val data: List<User>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
) : ApiResponse {
    override fun isValid(): Boolean = true
}

fun UsersResponse.asExternalModel() = UsersData(
    userList = data.map { it.asExternalModel() },
    page = page,
    perPage = per_page,
    total = total,
    totalPages = total_pages,
)

@Serializable
data class Support(
    val text: String,
    val url: String
)

@Serializable
data class User(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
) : ApiResponse {
    override fun isValid(): Boolean = id >= 0
}

fun User.asExternalModel() = UserData(
    id = id,
    firstName = first_name,
    lastName = last_name,
    emailAddress = email,
    avatarImg = avatar,
)