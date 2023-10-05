package com.mvptest.presentation.ui.newproject

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvptest.domain.ProjectsRepository
import com.mvptest.domain.models.Project
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class NewProjectViewModel @Inject constructor(private val projectsRepository: ProjectsRepository) : ViewModel() {

    var state by mutableStateOf(NewProjectViewState())

    fun saveProject(){
        viewModelScope.launch {
            projectsRepository.saveProject(Project(id = UUID.randomUUID().toString(), state.title!!, state.address!!, state.startDate!!, state.contact, state.contactPhone))
        }
    }

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