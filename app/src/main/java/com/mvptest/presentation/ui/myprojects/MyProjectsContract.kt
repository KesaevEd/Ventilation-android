package com.mvptest.presentation.ui.myprojects

import com.mvptest.domain.models.Project

class MyProjectsContract {

    data class State(
        val projects: List<com.mvptest.domain.models.Project>,
        val isLoading: Boolean = false
    )
}