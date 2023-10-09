package com.mvptest.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mvptest.data.database.entities.RoomDbEntity

@Dao
interface RoomsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoom(room: RoomDbEntity)

    @Query("SELECT * FROM rooms WHERE project_id = :projectId")
    suspend fun getRoomsByProjectId(projectId: String): List<RoomDbEntity>

    @Query("SELECT * FROM rooms WHERE id = :id")
    suspend fun getRoomById(id: String): RoomDbEntity
}