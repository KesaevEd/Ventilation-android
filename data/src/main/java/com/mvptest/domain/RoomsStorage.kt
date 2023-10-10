package com.mvptest.domain

import com.mvptest.domain.models.RoomDetails

interface RoomsStorage {

    suspend fun insertRoom(room: RoomDetails, projectId: String)

    suspend fun getRoomsByProjectId(projectId: String): List<RoomDetails>?

    suspend fun getRoomById(id: String): RoomDetails?

    suspend fun deleteRoom(id:String)

    suspend fun deleteRoomsByProjectId(projectId: String)
}