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
    @SerializedName("projectId")
    val projectId: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("systemNumber")
    val systemNumber: String?,
    @SerializedName("ventSystemDestination")
    val ventSystemDestination: String?,
    @SerializedName("airExchangePerformance")
    val airExchangePerformance: String?,
    @SerializedName("pressureLoss")
    val pressureLoss: String?,
    @SerializedName("airDuctArea")
    val airDuctArea: String?,
    @SerializedName("startDate")
    val startDate: String?,
    @SerializedName("heaterType")
    val heaterType: String?,
    @SerializedName("heaterPerformance")
    val heaterPerformance: String?,
    @SerializedName("isAirConditioner")
    val isAirConditioner: Boolean?,
    @SerializedName("airConditionerPerformance")
    val airConditionerPerformance: String?,
    @SerializedName("deadLines")
    val deadLines: String?,
    @SerializedName("comment")
    val comment: String?
)
