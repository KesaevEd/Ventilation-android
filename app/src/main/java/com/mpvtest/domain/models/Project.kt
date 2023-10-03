package com.mpvtest.domain.models

import java.util.Date

data class Project(
    val id: Int,
    val title: String,
    val address: String,
    val startDate: String
)

data class ProjectDetails(
    val id: Int,
    val title: String,
    val address: String,
    val startDate: Date,
    val contactName: String,
    val contactPhone: String,
    val comment: String,
)
