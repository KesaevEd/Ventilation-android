package com.mpvtest.presentation.ui.myprojects

import com.mpvtest.domain.models.Project

class MyProjectsContract {

    data class State(
        val projects: List<Project>,
        val isLoading: Boolean = false
    )
}