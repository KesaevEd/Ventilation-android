package com.mvptest.domain

import com.mvptest.data.network.requests.LoginRequest
import com.mvptest.data.network.requests.RegisterRequest
import com.mvptest.data.network.requests.SendCodeRequest
import com.mvptest.data.network.responses.UserResponse
import retrofit2.Response

interface UserRepository {
    suspend fun sendCodeToEmail(sendCodeRequest: SendCodeRequest): Response<Unit>
    suspend fun registration(registerRequest: RegisterRequest): Response<UserResponse>
    suspend fun login(loginRequest: LoginRequest): Response<UserResponse>
    suspend fun hello(): String

}