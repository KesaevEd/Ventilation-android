package com.mvptest.data

import android.util.Log
import com.mvptest.data.network.RoomsApi
import com.mvptest.data.network.mappers.toProject
import com.mvptest.data.network.mappers.toRoomDetails
import com.mvptest.data.network.mappers.toRoomRequest
import com.mvptest.domain.RoomsRepository
import com.mvptest.domain.RoomsStorage
import com.mvptest.domain.models.RoomDetails
import javax.inject.Inject

class RoomsRepositoryImpl @Inject constructor(private val roomsStorage: RoomsStorage, private val roomsApi: RoomsApi):
    RoomsRepository {

    override suspend fun fetchRooms(userId: String) {
        val roomsResponse = roomsApi.getRoomsByUserId(userId)

        if(roomsResponse.code() == 200 && roomsResponse.body() != null) {
            Log.d("saveroom","fetchRooms = ${roomsResponse.body()}")
            for (room in roomsResponse.body()!!.rooms) {
                Log.d("saveroom","room = $room")
                roomsStorage.insertRoom(room.toRoomDetails(), room.projectId)
            }
        }
    }

    override suspend fun saveRoom(room: RoomDetails, userId: String, projectId: String) {
        roomsStorage.insertRoom(room, projectId)
        roomsApi.saveRoom(room.toRoomRequest(userId = userId, projectId = projectId))
    }

    override suspend fun getRoomsByProjectId(projectId: String): List<RoomDetails>? {
        return roomsStorage.getRoomsByProjectId(projectId = projectId)
    }

    override suspend fun getRoomById(id: String): RoomDetails? {
        return roomsStorage.getRoomById(id)
    }

    override suspend fun deleteRoom(id: String) {
        roomsStorage.deleteRoom(id)
        roomsApi.deleteRoom(roomId = id)
    }

    override suspend fun deleteRoomByProjectId(projectId: String) {
        roomsStorage.getRoomsByProjectId(projectId)
    }
}