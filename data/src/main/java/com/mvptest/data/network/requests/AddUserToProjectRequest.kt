package com.mvptest.data.network.requests

data class AddUserToProjectRequest(
    val email: String,
    val projectId: String
)
