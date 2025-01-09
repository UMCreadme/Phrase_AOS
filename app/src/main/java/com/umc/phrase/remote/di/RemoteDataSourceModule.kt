package com.umc.phrase.remote.di

import com.umc.phrase.data.datasources.BookRemoteDataSource
import com.umc.phrase.remote.datasources.BookRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RemoteDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindBookRemoteDataSource(
        bookRemoteDataSourceImpl: BookRemoteDataSourceImpl
    ): BookRemoteDataSource
}