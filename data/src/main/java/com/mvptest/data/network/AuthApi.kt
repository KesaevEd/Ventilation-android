package com.mvptest.data.network

import com.mvptest.data.network.requests.LoginRequest
import com.mvptest.data.network.requests.RegisterRequest
import com.mvptest.data.network.requests.SendCodeRequest
import com.mvptest.data.network.responses.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApi {

    @POST("/send_code")
    suspend fun sendCode(
        @Body sendCodeRequest: SendCodeRequest
    ): Response<Unit>

    @POST("/register")
    suspend fun registration(
        @Body registerRequest: RegisterRequest
    ): Response<UserResponse>

    @POST("/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<UserResponse>

    @GET("/")
    suspend fun hello(): String
}