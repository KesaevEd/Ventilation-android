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

    fun init() {

    }

    var state by mutableStateOf(NewProjectViewState())

    lateinit var projectId: String
        private set

    fun saveProject() {
        viewModelScope.launch {
            projectId = UUID.randomUUID().toString()
            projectsRepository.saveProject(
                Project(
                    id = projectId,
                    state.title!!,
                    state.address!!,
                    state.startDate!!,
                    state.contact,
                    state.contactPhone
                )
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