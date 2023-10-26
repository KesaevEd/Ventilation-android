package com.mvptest.data.network.responses

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class RoomsResponse(
    @SerializedName("rooms")
    val rooms: List<RoomResponse>
)

@Serializable
data class RoomResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("project_id")
    val projectId: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("system_number")
    val systemNumber: String,
    @SerializedName("room-volume")
    val roomVolume: String,
    @SerializedName("room_destination")
    val roomDestination: String,
    @SerializedName("air_exchange_performance")
    val airExchangePerformance: String,
    @SerializedName("pressure_loss")
    val pressureLoss: String,
    @SerializedName("air_duct_area")
    val airDuctArea: String,
    @SerializedName("start_date")
    val startDate: String,
    @SerializedName("heater_type")
    val heaterType: String,
    @SerializedName("heater_performance")
    val heaterPerformance: String,
    @SerializedName("is_air_conditioner")
    val isAirConditioner: Boolean,
    @SerializedName("air_conditioner_performance")
    val airConditionerPerformance: String,
    @SerializedName("dead_lines")
    val deadLines: String,
    @SerializedName("comment")
    val comment: String
)
