package com.mvptest.domain

import android.content.Context
import com.mvptest.domain.models.Project
import com.mvptest.domain.models.RoomDetails
import retrofit2.Response

interface ProjectsRepository {

    suspend fun fetchProjects(userId: String)

    suspend fun saveProject(project: Project, userId: String)

    suspend fun getMyProjects(): List<Project>

    suspend fun getProjectById(id: String): Project?

    suspend fun deleteProject(id: String)

    suspend fun shareProjectPdfFile(project: Project, rooms: List<RoomDetails>, context: Context)

    suspend fun addNewUserToProject(projectId: String, email: String): Response<Unit>
}
