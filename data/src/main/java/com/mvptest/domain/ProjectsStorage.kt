package com.mvptest.domain

import com.mvptest.domain.models.Project

interface ProjectsStorage {

    suspend fun saveProject(project: Project, userId: String)

    suspend fun getMyProjectsFromDb(): List<Project>

    suspend fun getProjectById(id: String): Project?

    suspend fun deleteProject(id: String)
}