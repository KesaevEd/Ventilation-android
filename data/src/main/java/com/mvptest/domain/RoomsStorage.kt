package com.mvptest.domain

import com.mvptest.domain.models.RoomDetails

interface RoomsStorage {

    suspend fun insertRoom(room: RoomDetails, projectId: String)

    suspend fun getRoomsByProjectId(projectId: Int): List<RoomDetails>

    suspend fun getRoomById(id: Int): RoomDetails
}