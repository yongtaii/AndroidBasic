package com.jworld.network.reqres.model

import com.jworld.network.common.data.ApiResponse
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
)