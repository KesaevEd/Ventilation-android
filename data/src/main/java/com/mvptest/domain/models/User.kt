package com.mvptest.domain.models

data class User(
    val id: String? = "",
    val token: String,
    val email: String? = "",
    val password: String? = ""
)