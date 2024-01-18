package com.mvptest.domain

import android.content.Context
import androidx.room.Room
import com.mvptest.domain.models.Project
import com.mvptest.domain.models.RoomDetails

interface ProjectsRepository {

    suspend fun fetchProjects(userId: String)

    suspend fun saveProject(project: Project, userId: String)

    suspend fun getMyProjects(): List<Project>

    suspend fun getProjectById(id: String): Project?

    suspend fun deleteProject(id: String)

    suspend fun shareProjectPdfFile(project: Project, rooms: List<RoomDetails>, context: Context)
}
