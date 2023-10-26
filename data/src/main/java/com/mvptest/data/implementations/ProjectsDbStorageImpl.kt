package com.mvptest.data.implementations

import com.mvptest.data.database.dao.ProjectsDao
import com.mvptest.data.database.mappers.toDbEntity
import com.mvptest.data.database.mappers.toProject
import com.mvptest.domain.ProjectsStorage
import com.mvptest.domain.models.Project
import javax.inject.Inject

class ProjectsDbStorageImpl @Inject constructor(
    private val projectsDao: ProjectsDao
) :
    ProjectsStorage {

    override suspend fun saveProject(project: Project, userId: String) {
        projectsDao.insertProject(project.toDbEntity())
    }

    override suspend fun getMyProjectsFromDb(): List<Project> {
        return projectsDao.getMyProjects().map { it.toProject() }
    }

    override suspend fun getProjectById(id: String): Project? {
        val res = projectsDao.getProjectById(id)
        return res?.toProject()
    }

    override suspend fun deleteProject(id: String) {
        projectsDao.deleteProject(id)
    }
}