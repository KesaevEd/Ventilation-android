package com.mvptest.data

import com.mvptest.data.network.AuthApi
import com.mvptest.data.network.requests.LoginRequest
import com.mvptest.data.network.requests.RegisterRequest
import com.mvptest.data.network.requests.SendCodeRequest
import com.mvptest.data.network.responses.UserResponse
import com.mvptest.domain.UserRepository
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val authApi: AuthApi, private val sharedPrefStorage: SharedPrefStorage) : UserRepository {
    override suspend fun sendCodeToEmail(sendCodeRequest: SendCodeRequest): Response<Unit> {
        return authApi.sendCode(sendCodeRequest)
    }

    override suspend fun registration(registerRequest: RegisterRequest): Response<UserResponse> {
        return authApi.registration(registerRequest)
    }

    override suspend fun login(loginRequest: LoginRequest): Response<UserResponse> {
        val userResponse = authApi.login(loginRequest)
        sharedPrefStorage.token = userResponse.body()?.token
        return userResponse
    }

    override suspend fun sendCodeToEmailChangePassword(sendCodeRequest: SendCodeRequest): Response<Unit> {
        return authApi.sendCodeChangePassword(sendCodeRequest)
    }

    override suspend fun changePassword(loginRequest: LoginRequest): Response<Unit> {
        return authApi.changePassword(loginRequest)
    }

    override suspend fun hello(): String {
        return authApi.hello()
    }
}