package com.mvptest.data.network.mappers

import com.mvptest.data.network.responses.UserResponse
import com.mvptest.domain.models.User

fun UserResponse.toUser(): User {
    return User(
        token = token
    )
}