package com.mvptest.data.implementations

import com.mvptest.data.database.dao.RoomsDao
import com.mvptest.data.database.mappers.toDbEntity
import com.mvptest.data.database.mappers.toRoomDetails
import com.mvptest.domain.RoomsStorage
import com.mvptest.domain.models.RoomDetails
import javax.inject.Inject

class RoomsDbStorageImpl @Inject constructor(private val roomsDao: RoomsDao): RoomsStorage {
    override suspend fun insertRoom(room: RoomDetails, projectId: String) {
        roomsDao.insertRoom(room.toDbEntity(projectId))
    }

    override suspend fun getRoomsByProjectId(projectId: String): List<RoomDetails>? {
        return roomsDao.getRoomsByProjectId(projectId)?.map { it.toRoomDetails() }
    }

    override suspend fun getRoomById(id: String): RoomDetails? {
        return roomsDao.getRoomById(id)?.toRoomDetails()
    }

    override suspend fun deleteRoom(id: String) {
        roomsDao.deleteRoom(id)
    }

    override suspend fun deleteRoomsByProjectId(projectId: String) {
        roomsDao.deleteRoomsBuProjectId(projectId)
    }
}