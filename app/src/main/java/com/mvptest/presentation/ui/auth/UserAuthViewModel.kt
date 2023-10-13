package com.mvptest.presentation.ui.auth

import androidx.lifecycle.ViewModel
import com.mvptest.data.SharedPrefStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserAuthViewModel @Inject constructor(private val sharedPrefStorage: SharedPrefStorage): ViewModel() {

    val token = sharedPrefStorage.token

    fun setToken(token: String){
        sharedPrefStorage.token = token
    }

}