package com.mvptest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mvptest.data.database.dao.ProjectsDao
import com.mvptest.data.database.dao.RoomsDao
import com.mvptest.data.database.entities.ProjectDbEntity
import com.mvptest.data.database.entities.RoomDbEntity

@Database(
    entities = [ProjectDbEntity::class, RoomDbEntity::class],
    version = 2,
)
abstract class DataBase : RoomDatabase() {

    companion object {
        const val NAME = "data_base"
    }

    abstract fun projectsDao(): ProjectsDao

    abstract fun roomsDao(): RoomsDao
}


