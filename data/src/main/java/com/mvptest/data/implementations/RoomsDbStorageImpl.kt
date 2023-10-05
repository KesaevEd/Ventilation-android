package com.mvptest.data.implementations

import com.mvptest.data.database.dao.RoomsDao
import com.mvptest.data.database.mappers.toDbEntity
import com.mvptest.data.database.mappers.toRoomDetails
import com.mvptest.domain.RoomsStorage
import com.mvptest.domain.models.RoomDetails
import javax.inject.Inject

class RoomsDbStorageImpl @Inject constructor(private val roomsDao: RoomsDao): RoomsStorage {
    override suspend fun insertRoom(room: RoomDetails, projectId: Int) {
        roomsDao.insertRoom(room.toDbEntity(projectId))
    }

    override suspend fun getRoomsByProjectId(projectId: Int): List<RoomDetails> {
        return roomsDao.getRoomsByProjectId(projectId).map { it.toRoomDetails() }
    }

    override suspend fun getRoomById(id: Int): RoomDetails {
        return roomsDao.getRoomById(id).toRoomDetails()
    }
}