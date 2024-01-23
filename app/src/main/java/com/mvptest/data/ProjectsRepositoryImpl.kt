package com.mvptest.data

import android.content.Context
import android.util.Log
import com.mvptest.data.network.ProjectsApi
import com.mvptest.data.network.mappers.toProject
import com.mvptest.data.network.mappers.toProjectRequest
import com.mvptest.data.network.requests.AddUserToProjectRequest
import com.mvptest.domain.ProjectsRepository
import com.mvptest.domain.ProjectsStorage
import com.mvptest.domain.models.Project
import com.mvptest.domain.models.RoomDetails
import com.mvptest.utils.ShareProjectHelper
import retrofit2.Response
import javax.inject.Inject

class ProjectsRepositoryImpl @Inject constructor(
    private val projectsStorage: ProjectsStorage,
    private val projectsApi: ProjectsApi,
) : ProjectsRepository {
    override suspend fun fetchProjects(userId: String) {
        val projectsResponse = projectsApi.getProjectsByUserId(userId)

        if (projectsResponse.code() == 200 && projectsResponse.body() != null) {
            Log.d("fetchProjects", "projects = ${projectsResponse.body()!!.projects}")
            for (project in projectsResponse.body()!!.projects) {
                projectsStorage.saveProject(project.toProject(), userId)
            }
        }
    }

    override suspend fun saveProject(project: Project, userId: String) {
        projectsStorage.saveProject(project, userId)
        projectsApi.saveProject(project.toProjectRequest(userId))
    }

    override suspend fun getMyProjects(): List<Project> {
        return projectsStorage.getMyProjectsFromDb()
    }

    override suspend fun getProjectById(id: String): Project? {
        return projectsStorage.getProjectById(id)
    }

    override suspend fun deleteProject(id: String) {
        projectsApi.deleteProject(id)
        projectsStorage.deleteProject(id)
    }

    override suspend fun shareProjectPdfFile(
        project: Project,
        rooms: List<RoomDetails>,
        context: Context,
    ) {
        val shareProjectHelper = ShareProjectHelper(context)
        shareProjectHelper.createPdfFromObject(project, rooms)
    }

    override suspend fun addNewUserToProject(projectId: String, email: String): Response<Unit> {
        return projectsApi.addNewUser(AddUserToProjectRequest(email, projectId))
    }
}
