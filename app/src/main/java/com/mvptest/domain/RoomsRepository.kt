package com.mvptest.domain

import com.mvptest.domain.models.RoomDetails

interface RoomsRepository {

    suspend fun saveRoom(room: RoomDetails, projectId: Int)

    suspend fun getRoomsByProjectId(projectId: Int): List<RoomDetails>

    suspend fun getRoomById(id:Int): RoomDetails
}