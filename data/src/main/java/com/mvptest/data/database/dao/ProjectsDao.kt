package com.mvptest.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mvptest.data.database.entities.ProjectDbEntity

@Dao
interface ProjectsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProject(project: ProjectDbEntity)

    @Query("SELECT * FROM projects")
    suspend fun getMyProjects(): List<ProjectDbEntity>

    @Query("SELECT * FROM projects WHERE id = :id")
    suspend fun getProjectById(id: Int): ProjectDbEntity
}