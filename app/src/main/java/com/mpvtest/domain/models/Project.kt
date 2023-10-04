package com.mpvtest.domain.models

data class Project(
    val id: Int,
    val title: String,
    val address: String,
    val startDate: String,
    val rooms: List<RoomDetails>? = emptyList()
)


