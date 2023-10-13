package com.mvptest.di

import android.content.Context
import com.mvptest.data.SharedPrefStorage
import com.mvptest.data.implementations.ProjectsDbStorageImpl
import com.mvptest.data.implementations.RoomsDbStorageImpl
import com.mvptest.domain.ProjectsStorage
import com.mvptest.domain.RoomsStorage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DbStorageModule {

    @Binds
    fun bindProjectsStorage(projectsDbStorageImpl: ProjectsDbStorageImpl): ProjectsStorage

    @Binds
    fun bindRoomsStorage(roomsDbStorageImpl: RoomsDbStorageImpl): RoomsStorage
}