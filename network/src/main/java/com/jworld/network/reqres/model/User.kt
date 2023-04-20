package com.jworld.network.reqres.model

import com.jworld.network.common.data.CommonResponse
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
)