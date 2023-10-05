package com.mvptest.di

import android.content.Context
import androidx.room.Room
import com.mvptest.data.database.DataBase
import com.mvptest.data.database.dao.ProjectsDao
import com.mvptest.data.database.dao.RoomsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {


    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ): DataBase {
        return Room.databaseBuilder(
            appContext,
            DataBase::class.java,
            DataBase.NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideProjectsDao(dataBase: DataBase): ProjectsDao {
        return dataBase.projectsDao()
    }

    @Provides
    @Singleton
    fun provideRoomDao(dataBase: DataBase): RoomsDao {
        return dataBase.roomsDao()
    }
}