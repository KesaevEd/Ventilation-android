package com.mvptest.domain

import com.mvptest.domain.models.RoomDetails

interface RoomsRepository {

    suspend fun fetchRooms(userId: String)

    suspend fun saveRoom(room: RoomDetails, userId: String, projectId: String)

    suspend fun getRoomsByProjectId(projectId: String): List<RoomDetails>?

    suspend fun getRoomById(id:String): RoomDetails?

    suspend fun deleteRoom(id: String)

    suspend fun deleteRoomByProjectId(projectId: String)
}