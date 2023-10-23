package com.mvptest.presentation.ui.auth

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvptest.data.SharedPrefStorage
import com.mvptest.data.network.mappers.toUser
import com.mvptest.data.network.requests.LoginRequest
import com.mvptest.data.network.requests.RegisterRequest
import com.mvptest.data.network.requests.SendCodeRequest
import com.mvptest.domain.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.Random
import javax.inject.Inject

@HiltViewModel
class UserAuthViewModel @Inject constructor(
    private val sharedPrefStorage: SharedPrefStorage,
    private val userRepository: UserRepository
) : ViewModel() {

    val token = sharedPrefStorage.token

    private val codeToEmail = generateCode()

    var state by mutableStateOf(UserAuthViewState())
        private set

    fun registration() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            try {
                val response = userRepository.registration(
                    registerRequest = RegisterRequest(
                        email = state.email!!,
                        password = state.password!!
                    )
                )
                Log.d("registrationScreen", "response = $response")

                when (response.code()) {
                    200 -> {
                        state = state.copy(
                            user = response.body()?.toUser(),
                            isLoading = false,
                            isSuccessRegistration = true
                        )
                        saveUserInSharedPref(
                            response.body()!!.token,
                            state.email!!,
                            state.password!!
                        )
                    }

                    else -> {
                        state = state.copy(isLoading = false, somethingWrong = true)
                    }
                }
            } catch (e: Exception) {
                state = state.copy(isLoading = false, somethingWrong = true)
                Log.d("registrationScreen", "registration Exception = $e")
            }
        }
    }

    fun sendCodeToEmail() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            try {
                val response = userRepository.sendCodeToEmail(
                    sendCodeRequest = SendCodeRequest(
                        state.email!!,
                        codeToEmail
                    )
                )

                when (response.code()) {
                    200 -> {
                        state = state.copy(
                            isLoading = false,
                            isSuccessSendCode = true
                        )
                    }

                    409 -> {
                        state = state.copy(isLoading = false, isEmailAlreadyExist = true)
                    }

                    500 -> {
                        state = state.copy(isLoading = false, isEmailNotFound = true)
                    }

                    else -> {
                        state = state.copy(isLoading = false, somethingWrong = true)
                    }
                }
            } catch (e: Exception) {
                state = state.copy(isLoading = false, somethingWrong = true)
                Log.d("registrationScreen", "sendCodeToEmail Exception = $e")
            }
        }
    }

    fun login() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            try {
                val userResponse = userRepository.login(
                    loginRequest = LoginRequest(
                        email = state.email!!,
                        password = state.password!!
                    )
                )
                Log.d("login", "userResponse = $userResponse")
                when (userResponse.code()) {
                    200 -> {
                        state = state.copy(
                            user = userResponse.body()?.toUser(),
                            isLoading = false,
                            isSuccessLogin = true
                        )
                        saveUserInSharedPref(
                            userResponse.body()!!.token,
                            state.email!!,
                            state.password!!
                        )
                    }
                    400 -> {
                        state = state.copy(isLoading = false, isPasswordInvalid = true)
                    }
                    404 -> {
                        state = state.copy(isLoading = false, isUserNotFound = true)
                    }

                    else -> {
                        state = state.copy(isLoading = false, somethingWrong = true)
                    }
                }
            }catch (e: Exception){
                state = state.copy(isLoading = false, somethingWrong = true)
                Log.d("registrationScreen", "registration Exception = $e")
            }
        }
    }

    private fun generateCode(): String {
        val random = Random().nextInt(90000) + 10000
        return random.toString()
    }

    fun checkEmailCode(inputCode: String) {
        if (inputCode != codeToEmail) {
            state = state.copy(isCodeIncorrect = true)
        } else {
            registration()
        }
    }

    fun setEmail(email: String) {
        state = state.copy(email = email)
    }

    fun setPassword(password: String) {
        state = state.copy(password = password)
    }

    fun stopSuccessRegister() {
        state = state.copy(isSuccessRegistration = false, somethingWrong = false)
    }

    fun stopSuccessSendCode() {
        state = state.copy(isSuccessSendCode = false, somethingWrong = false, isEmailNotFound = false, isUserNotFound = false)
    }

    fun stopSuccessLogin() {
        state = state.copy(isSuccessLogin = false, somethingWrong = false, isUserNotFound = false, isPasswordInvalid = false)
    }

    fun clearAllError(){
        state = state.copy(somethingWrong = false, isEmailNotFound = false, isUserNotFound = false, isPasswordInvalid = false, isCodeIncorrect = false, isEmailAlreadyExist = false)
    }

    private fun saveUserInSharedPref(token: String, email: String, password: String) {
        sharedPrefStorage.token = token
        sharedPrefStorage.email = email
        sharedPrefStorage.password = password
    }
}