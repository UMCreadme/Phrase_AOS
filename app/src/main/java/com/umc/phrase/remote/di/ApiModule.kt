package com.umc.phrase.remote.di

import com.umc.phrase.remote.api.BookApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {
    @Provides
    @Singleton
    fun provideBookApiService(
        @NetworkModule.MainRetrofit retrofit: Retrofit
    ): BookApiService = retrofit.create(BookApiService::class.java)
}