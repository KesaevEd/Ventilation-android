package com.mvptest.presentation.ui.project.projectdetails

data class ProjectDetailsViewState(
    val creatorId: String? = "",
    val title: String? = "",
    val address: String? = "",
    val startDate: String? = "",
    val contact: String? = "",
    val contactPhone: String? = "",
    val rooms: List<RoomItemUiEntity>? = emptyList(),
    val addedUserEmail: String? = "",
    val isEmailNotFound: Boolean? = false,
    val somethingWrong: Boolean? = false,
    val isSuccessAddingUser: Boolean? = false,
    val isLoading: Boolean? = false,
)

data class RoomItemUiEntity(
    val id: String,
    val title: String,
)
