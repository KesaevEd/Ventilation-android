package com.mvptest.data

import com.mvptest.domain.RoomsRepository
import com.mvptest.domain.RoomsStorage
import com.mvptest.domain.models.RoomDetails
import javax.inject.Inject

class RoomsRepositoryImpl @Inject constructor(private val roomsStorage: RoomsStorage):
    RoomsRepository {
    override suspend fun saveRoom(room: RoomDetails, projectId: String) {
        roomsStorage.insertRoom(room, projectId)
    }

    override suspend fun getRoomsByProjectId(projectId: String): List<RoomDetails> {
        return roomsStorage.getRoomsByProjectId(projectId = projectId)
    }

    override suspend fun getRoomById(id: String): RoomDetails {
        return roomsStorage.getRoomById(id)
    }
}