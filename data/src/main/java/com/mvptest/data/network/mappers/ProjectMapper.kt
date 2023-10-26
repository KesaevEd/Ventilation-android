package com.mvptest.data.network.mappers

import com.mvptest.data.network.requests.NewProjectRequest
import com.mvptest.data.network.responses.ProjectResponse
import com.mvptest.domain.models.Project

fun ProjectResponse.toProject(): Project {
    return Project(
        id = id,
        title = title,
        address = address,
        startDate = startDate,
        contact = contact,
        contactPhone = contactPhone
    )
}

fun Project.toProjectRequest(userId: String): NewProjectRequest {
    return NewProjectRequest(
        id = id,
        userId = userId,
        title = title,
        address = address,
        startDate = startDate ?: "",
        contact = contact ?: "",
        contactPhone = contactPhone ?: ""
    )
}