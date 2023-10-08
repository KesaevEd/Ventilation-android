package com.mvptest.domain.models

data class Project(
    val id: String,
    val title: String,
    val address: String,
    val startDate: String,
    val contact: String? = "",
    val contactPhone: String? = "",
    val rooms: List<RoomDetails>? = emptyList()
)


