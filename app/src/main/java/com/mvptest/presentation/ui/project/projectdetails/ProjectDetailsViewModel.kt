package com.mvptest.presentation.ui.project.projectdetails

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvptest.domain.ProjectsRepository
import com.mvptest.domain.RoomsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectDetailsViewModel @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    private val roomsRepository: RoomsRepository
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
            if(project != null && rooms != null) {
                state = state.copy(
                    title = project.title,
                    address = project.address,
                    startDate = project.startDate,
                    contact = project.contact,
                    contactPhone = project.contactPhone,
                    rooms = rooms.map { RoomItemUiEntity(it.id, it.title) })
            }
        }
    }

    fun deleteProject(){
        viewModelScope.launch {
            roomsRepository.deleteRoomByProjectId(temporalProjectId)
            projectsRepository.deleteProject(temporalProjectId)
        }
    }

    fun clearState() {
        state = state.copy(null, null, null, null, null, null)
        temporalProjectId = ""
    }

}