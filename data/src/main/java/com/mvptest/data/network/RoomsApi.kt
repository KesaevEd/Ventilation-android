package com.mvptest.data.network

import com.mvptest.data.network.requests.NewRoomRequest
import com.mvptest.data.network.requests.SendCodeRequest
import com.mvptest.data.network.responses.RoomResponse
import com.mvptest.data.network.responses.RoomsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RoomsApi {

    @POST("/save_room")
    suspend fun saveRoom(
        @Body newRoomRequest: NewRoomRequest
    ): Response<Unit>

    @GET("/get_rooms/{user_id}")
    suspend fun getRoomsByUserId(
        @Path("user_id") userId: String
    ): Response<RoomsResponse>

    @DELETE("/delete_room/{room_id}")
    suspend fun deleteRoom(
        @Path("room_id") roomId: String
    ): Response<Unit>
}