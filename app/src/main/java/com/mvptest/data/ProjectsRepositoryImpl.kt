package com.mvptest.data

import android.util.Log
import com.mvptest.domain.ProjectsRepository
import com.mvptest.domain.ProjectsStorage
import com.mvptest.domain.models.Project
import javax.inject.Inject

class ProjectsRepositoryImpl @Inject constructor(private val projectsStorage: ProjectsStorage):
    ProjectsRepository {
    override suspend fun saveProject(project: Project) {
        projectsStorage.saveProject(project)
    }

    override suspend fun getMyProjects(): List<Project> {
        return projectsStorage.getMyProjects()
    }

    override suspend fun getProjectById(id: String): Project {
        val res = projectsStorage.getProjectById(id)
        return res
    }
}