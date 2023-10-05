package com.mvptest.presentation.ui.myprojects

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvptest.domain.ProjectsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyProjectsViewModel @Inject constructor(private val projectsRepository: ProjectsRepository) :
    ViewModel() {

    var state by mutableStateOf(MyProjectsViewState())
        private set

    fun getMyProjects() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val projects = projectsRepository.getMyProjects()
            state = state.copy(projects = projects, isLoading = false)
        }
    }

}