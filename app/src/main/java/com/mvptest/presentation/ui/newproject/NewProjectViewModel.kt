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
class NewProjectViewModel @Inject constructor(private val projectsRepository: ProjectsRepository) :
    ViewModel() {

    var state by mutableStateOf(NewProjectViewState())

    var projectId = ""

    fun saveProject() {
        viewModelScope.launch {
            if(projectId == "") {
                projectId = UUID.randomUUID().toString()
            }
            projectsRepository.saveProject(
                Project(
                    id = projectId,
                    state.title ?: "",
                    state.address ?: "",
                    state.startDate,
                    state.contact,
                    state.contactPhone
                )
            )
        }
    }

    fun initEditMode(id: String) {
        viewModelScope.launch {
            projectId = id
            val project = projectsRepository.getProjectById(projectId)
            state = state.copy(
                title = project.title,
                address = project.address,
                startDate = project.startDate,
                contact = project.contact,
                contactPhone = project.contactPhone
            )
        }
    }

    fun clearState() {
        state = state.copy(
            title = "",
            address = "",
            startDate = "",
            contact = "",
            contactPhone = ""
        )
        projectId = ""
    }

    fun setTitle(title: String) {
        state = state.copy(title = title)
    }

    fun setAddress(address: String) {
        state = state.copy(address = address)
    }

    fun setStartDate(startDate: String) {
        state = state.copy(startDate = startDate)
    }

    fun setContact(contact: String) {
        state = state.copy(contact = contact)
    }

    fun setContactPhone(contactPhone: String) {
        state = state.copy(contactPhone = contactPhone)
    }
}