package com.jworld.core.data.user.model

import com.jworld.network.reqres.model.User
import com.jworld.network.reqres.model.UsersResponse

fun UsersResponse.toExternal() = data::toExternal

fun List<User>.toExternal() = map (User::toExternal)

fun User.toExternal() = User(
    id = id,
    firstName = first_name,
    lastName = last_name,
    emailAddress = email,
    avatarImg = avatar,
)