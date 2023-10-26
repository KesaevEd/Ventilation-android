package com.mvptest.domain

import com.mvptest.domain.models.Project

interface ProjectsRepository {

    suspend fun fetchProjects(userId: String)

    suspend fun saveProject(project: Project, userId: String)

    suspend fun getMyProjects(): List<Project>

    suspend fun getProjectById(id:String): Project?

    suspend fun deleteProject(id: String)
}