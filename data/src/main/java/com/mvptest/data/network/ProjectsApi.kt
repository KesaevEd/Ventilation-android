package com.mvptest.data.network

import com.mvptest.data.network.requests.NewProjectRequest
import com.mvptest.data.network.responses.ProjectsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProjectsApi {

    @POST("/save_project")
    suspend fun saveProject(
        @Body newProjectRequest: NewProjectRequest
    ): Response<Unit>

    @GET("/get_projects/{user_id}")
    suspend fun getProjectsByUserId(
        @Path("user_id") userId: String
    ): Response<ProjectsResponse>

    @DELETE("/delete_project/{project_id}")
    suspend fun deleteProject(
        @Path("project_id") projectId: String
    ): Response<Unit>
}