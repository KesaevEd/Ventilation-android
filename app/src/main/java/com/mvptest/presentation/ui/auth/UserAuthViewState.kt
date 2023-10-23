package com.mvptest.presentation.ui.auth

import com.mvptest.data.network.requests.LoginRequest
import com.mvptest.data.network.requests.RegisterRequest
import com.mvptest.domain.models.User
import io.reactivex.internal.operators.single.SingleDoOnSuccess

data class UserAuthViewState(
    val isLoading: Boolean? = false,
    val isSuccessRegistration: Boolean? = false,
    val isSuccessSendCode: Boolean? = false,
    val isSuccessLogin: Boolean? = false,
    val isPasswordInvalid: Boolean? = false,
    val isCodeIncorrect: Boolean? = false,
    val isEmailNotFound: Boolean? = false,
    val isEmailAlreadyExist: Boolean? = false,
    val isUserNotFound: Boolean? = false,
    val user: User? = null,
    val somethingWrong: Boolean? = false,
    val email: String? = null,
    val password: String? = null
)