package com.mvptest.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mvptest.presentation.ui.myprojects.MyProjectsViewModel
import com.mvptest.presentation.ui.newproject.NewProjectViewModel
import com.mvptest.presentation.ui.newroom.NewRoomViewModel
import com.mvptest.presentation.ui.projectdetails.ProjectDetailsViewModel
import com.mvptest.presentation.ui.roomdetails.RoomDetailsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object AppModule {

    @Provides
    fun provideNewProjectViewModel(activity: AppCompatActivity): NewProjectViewModel {
        return ViewModelProvider(activity)[NewProjectViewModel::class.java]
    }

    @Provides
    fun provideNewRoomViewModel(activity: AppCompatActivity): NewRoomViewModel {
        return ViewModelProvider(activity)[NewRoomViewModel::class.java]
    }

    @Provides
    fun provideMyProjectsViewModel(activity: AppCompatActivity): MyProjectsViewModel {
        return ViewModelProvider(activity)[MyProjectsViewModel::class.java]
    }

    @Provides
    fun provideProjectDetailsViewModel(activity: AppCompatActivity): ProjectDetailsViewModel {
        return ViewModelProvider(activity)[ProjectDetailsViewModel::class.java]
    }

    @Provides
    fun provideRoomDetailsViewModel(activity: AppCompatActivity): RoomDetailsViewModel {
        return ViewModelProvider(activity)[RoomDetailsViewModel::class.java]
    }
}