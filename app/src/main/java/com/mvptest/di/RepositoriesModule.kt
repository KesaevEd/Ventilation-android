package com.mvptest.di

import com.mvptest.data.ProjectsRepositoryImpl
import com.mvptest.data.RoomsRepositoryImpl
import com.mvptest.data.UserRepositoryImpl
import com.mvptest.domain.ProjectsRepository
import com.mvptest.domain.RoomsRepository
import com.mvptest.domain.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindProjectsRepository(repository: ProjectsRepositoryImpl): ProjectsRepository

    @Binds
    fun bindRoomsRepository(repository: RoomsRepositoryImpl): RoomsRepository

    @Binds
    fun bindUserRepository(repository: UserRepositoryImpl): UserRepository
}