package com.mvptest.domain

import com.mvptest.domain.models.Project

interface ProjectsRepository {

    suspend fun saveProject(project: Project)

    suspend fun getMyProjects(): List<Project>

    suspend fun getProjectById(id:String): Project
}