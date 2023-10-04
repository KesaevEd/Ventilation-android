package com.mpvtest.presentation.ui.newproject

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewProjectViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(NewProjectViewState())

    fun setTitle(title: String){
        state = state.copy(title = title)
    }

    fun setAddress(address: String){
        state = state.copy(address = address)
    }

    fun setStartDate(startDate: String){
        state = state.copy(startDate = startDate)
    }

    fun setContact(contact: String){
        state = state.copy(contact = contact)
    }

    fun setContactPhone(contactPhone: String){
        state = state.copy(contactPhone = contactPhone)
    }
}