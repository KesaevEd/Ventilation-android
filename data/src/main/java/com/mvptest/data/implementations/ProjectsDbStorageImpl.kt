package com.mvptest.data.implementations

import android.util.Log
import com.mvptest.data.database.dao.ProjectsDao
import com.mvptest.data.database.mappers.toDbEntity
import com.mvptest.data.database.mappers.toProject
import com.mvptest.domain.ProjectsStorage
import com.mvptest.domain.models.Project
import javax.inject.Inject

class ProjectsDbStorageImpl @Inject constructor(private val projectsDao: ProjectsDao):
    ProjectsStorage {
    override suspend fun saveProject(project: Project) {
        projectsDao.insertProject(project.toDbEntity())
    }

    override suspend fun getMyProjects(): List<Project> {
        return projectsDao.getMyProjects().map { it.toProject() }
    }

    override suspend fun getProjectById(id: String): Project {
        val res = projectsDao.getProjectById(id)
        Log.d("getProjectById", "res = $res")
            return res.toProject()
    }
}