package com.mvptest.domain

import com.mvptest.domain.models.Project

interface ProjectsStorage {

    suspend fun saveProject(project: Project)

    suspend fun getMyProjects(): List<Project>

    suspend fun getProjectById(id: Int): Project
}