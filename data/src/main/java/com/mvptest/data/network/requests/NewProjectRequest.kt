package com.mvptest.data.network.requests

data class NewProjectRequest(
    val id: String,
    val userId: String,
    val title: String,
    val address: String,
    val startDate: String,
    val contact: String,
    val contactPhone: String,
)
