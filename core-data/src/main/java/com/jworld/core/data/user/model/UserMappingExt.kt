package com.jworld.core.data.user.model

import com.jworld.network.reqres.model.User
import com.jworld.network.reqres.model.UsersResponse

fun UsersResponse.toExternal() = UsersData(
    userList = data.toExternal(),
    page = page,
    perPage = per_page,
    total = total,
    totalPages = total_pages,
)

fun List<User>.toExternal() = map (User::toExternal)

fun User.toExternal() = User(
    id = id,
    firstName = first_name,
    lastName = last_name,
    emailAddress = email,
    avatarImg = avatar,
)