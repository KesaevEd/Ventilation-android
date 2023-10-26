package com.mvptest.data.network.responses

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ProjectsResponse(
    @SerializedName("projects")
    val projects: List<ProjectResponse>
)

@Serializable
data class ProjectResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("contact")
    val contact: String,
    @SerializedName("contactPhone")
    val contactPhone: String
)
