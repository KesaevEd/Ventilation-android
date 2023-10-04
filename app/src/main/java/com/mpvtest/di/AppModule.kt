package com.mpvtest.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mpvtest.presentation.ui.newproject.NewProjectViewModel
import com.mpvtest.presentation.ui.newroom.NewRoomViewModel
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
}