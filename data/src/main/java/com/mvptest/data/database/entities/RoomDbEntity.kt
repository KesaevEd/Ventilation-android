package com.mvptest.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rooms")
data class RoomDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "project_id") val projectId: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "systemNumber") val systemNumber: String,
    @ColumnInfo(name = "roomVolume") val roomVolume: Int,
    @ColumnInfo(name = "roomDestination") val roomDestination: String,
    @ColumnInfo(name = "airExchangePerformance") val airExchangePerformance: Int,
    @ColumnInfo(name = "pressureLoss") val pressureLoss: Int,
    @ColumnInfo(name = "airDuctArea") val airDuctArea: Int,
    @ColumnInfo(name = "heaterType") val heaterType: String,
    @ColumnInfo(name = "heaterPerformance") val heaterPerformance: Int,
    @ColumnInfo(name = "isAirConditioner") val isAirConditioner: Boolean,
    @ColumnInfo(name = "airConditionerPerformance") val airConditionerPerformance: Int,
    @ColumnInfo(name = "start_dates") val startDate: String,
    @ColumnInfo(name = "deadLines") val deadLines: String,
    @ColumnInfo(name = "comment") val comment: String,
)