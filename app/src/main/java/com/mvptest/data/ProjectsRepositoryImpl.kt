package com.mvptest.data

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

    override suspend fun getProjectById(id: Int): Project {
        return projectsStorage.getProjectById(id)
    }
}