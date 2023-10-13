package com.mvptest.di

import android.content.Context
import android.content.SharedPreferences
import com.mvptest.data.SharedPrefStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPrefModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPrefStorage{
        return SharedPrefStorage(context)
    }
}