package com.mvptest.presentation.ui.project.projectdetails

data class ProjectDetailsViewState (
    val title: String? = "",
    val address: String? = "",
    val startDate: String? = "",
    val contact: String? = "",
    val contactPhone: String? = "",
    val rooms: List<RoomItemUiEntity>? = emptyList()
)

data class RoomItemUiEntity(
    val id: String,
    val title: String
)