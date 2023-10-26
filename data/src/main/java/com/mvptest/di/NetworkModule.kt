package com.mvptest.di

import com.mvptest.data.network.AuthApi
import com.mvptest.data.network.ProjectsApi
import com.mvptest.data.network.RoomsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder().build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun providesAuthApi(retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)

    @Singleton
    @Provides
    fun providesProjectsApi(retrofit: Retrofit): ProjectsApi =
        retrofit.create(ProjectsApi::class.java)

    @Singleton
    @Provides
    fun providesRoomsApi(retrofit: Retrofit): RoomsApi =
        retrofit.create(RoomsApi::class.java)

    private companion object {
        private const val BASE_URL = "https://bbacj77bhkb0nbjdm7hl.containers.yandexcloud.net"
    }
}