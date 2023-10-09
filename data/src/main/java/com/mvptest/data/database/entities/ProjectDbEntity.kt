package com.mvptest.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "projects")
data class ProjectDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "address") val address: String,
    @ColumnInfo(name = "start_date") val startDate: String,
    @ColumnInfo(name = "contact") val contact: String,
    @ColumnInfo(name = "contact_phone") val contactPhone: String,
)
