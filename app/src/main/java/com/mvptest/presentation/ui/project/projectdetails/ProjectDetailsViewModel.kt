package com.mvptest.presentation.ui.project.projectdetails

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvptest.data.SharedPrefStorage
import com.mvptest.domain.ProjectsRepository
import com.mvptest.domain.RoomsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectDetailsViewModel @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    private val roomsRepository: RoomsRepository,
    private val sharedPrefStorage: SharedPrefStorage,
) : ViewModel() {

    var state by mutableStateOf(ProjectDetailsViewState())
        private set

    var temporalProjectId = ""
        private set

    fun getProjectById(projectId: String) {
        temporalProjectId = projectId
        viewModelScope.launch {
            val project = projectsRepository.getProjectById(projectId)
            val rooms = roomsRepository.getRoomsByProjectId(projectId)
            if (project != null && rooms != null) {
                state = state.copy(
                    creatorId = project.creatorId,
                    title = project.title,
                    address = project.address,
                    startDate = project.startDate,
                    contact = project.contact,
                    contactPhone = project.contactPhone,
                    rooms = rooms.map { RoomItemUiEntity(it.id, it.title) },
                )
            }
        }
    }

    fun isCreator(): Boolean = state.creatorId == sharedPrefStorage.userId

    fun deleteProject() {
        viewModelScope.launch {
            roomsRepository.deleteRoomByProjectId(temporalProjectId)
            projectsRepository.deleteProject(temporalProjectId)
        }
    }

    fun shareProjectPdfFile(context: Context) {
        viewModelScope.launch {
            val project = projectsRepository.getProjectById(temporalProjectId)
            if (project != null) {
                val rooms = roomsRepository.getRoomsByProjectId(temporalProjectId)
                projectsRepository.shareProjectPdfFile(project, rooms ?: emptyList(), context)
            }
        }
    }

    fun setAddingUserEmail(email: String) {
        state = state.copy(addedUserEmail = email)
    }

    fun addUserToProject() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            try {
                val response = projectsRepository.addNewUserToProject(
                    email = state.addedUserEmail ?: "",
                    projectId = temporalProjectId,
                )

                when (response.code()) {
                    200 -> {
                        state = state.copy(
                            isSuccessAddingUser = true,
                            isLoading = false,
                            somethingWrong = false,
                            isEmailNotFound = false,
                        )
                    }

                    404 -> {
                        state = state.copy(
                            isLoading = false,
                            somethingWrong = false,
                            isEmailNotFound = true,
                        )
                    }

                    else -> {
                        state = state.copy(
                            isLoading = false,
                            somethingWrong = true,
                            isEmailNotFound = false,
                        )
                    }
                }
            } catch (e: Exception) {
                state = state.copy(
                    isLoading = false,
                    somethingWrong = true,
                    isEmailNotFound = false,
                )
                Log.e("ProjectDetailsScreen", "addUserToProject Exception = $e")
            }
        }
    }

    fun clearErrors() {
        state = state.copy(
            addedUserEmail = null,
            isEmailNotFound = false,
            somethingWrong = false,
            isSuccessAddingUser = false,
        )
    }

    fun clearState() {
        state = state.copy(
            title = null,
            address = null,
            startDate = null,
            contact = null,
            contactPhone = null,
            rooms = null,
            addedUserEmail = null,
            isEmailNotFound = false,
            somethingWrong = false,
            isSuccessAddingUser = false,
        )
        temporalProjectId = ""
    }
}
