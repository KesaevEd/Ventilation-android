package com.mvptest.presentation.ui.myprojects

import com.mvptest.domain.models.Project

data class MyProjectsViewState(
    val projects: List<Project>? = emptyList(),
    val isLoading: Boolean? = false
)
