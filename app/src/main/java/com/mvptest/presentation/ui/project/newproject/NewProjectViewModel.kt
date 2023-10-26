package com.mvptest.presentation.ui.project.newproject

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvptest.data.SharedPrefStorage
import com.mvptest.domain.ProjectsRepository
import com.mvptest.domain.models.Project
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class NewProjectViewModel @Inject constructor(private val projectsRepository: ProjectsRepository, private val sharedPrefStorage: SharedPrefStorage) :
    ViewModel() {

    var state by mutableStateOf(NewProjectViewState())

    var projectId = ""

    private val userId = sharedPrefStorage.userId


    fun saveProject() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            if(projectId == "") {
                projectId = UUID.randomUUID().toString()
            }
            try {
                projectsRepository.saveProject(
                    project = Project(
                        id = projectId,
                        state.title ?: "",
                        state.address ?: "",
                        state.startDate,
                        state.contact,
                        state.contactPhone
                    ), userId = sharedPrefStorage.userId!!
                )
                state = state.copy(somethingWrong = false, isLoading = false)
            }catch (e: Exception){
                Log.d("saveProject","Exception = $e  userId = ${sharedPrefStorage.userId}")
                state = state.copy(somethingWrong = true, isLoading = false)
            }
        }
    }

    fun initEditMode(id: String) {
        viewModelScope.launch {
            projectId = id
            val project = projectsRepository.getProjectById(projectId)
            if(project != null) {
                state = state.copy(
                    title = project.title,
                    address = project.address,
                    startDate = project.startDate,
                    contact = project.contact,
                    contactPhone = project.contactPhone
                )
            }
        }
    }

    fun clearState() {
        state = state.copy(
            title = "",
            address = "",
            startDate = "",
            contact = "",
            contactPhone = "",
            somethingWrong = false
        )
        projectId = ""
    }

    fun clearAllError(){
        state = state.copy(somethingWrong = false)
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