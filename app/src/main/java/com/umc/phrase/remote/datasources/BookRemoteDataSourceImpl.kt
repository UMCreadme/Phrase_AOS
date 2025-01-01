package com.umc.phrase.remote.datasources

import com.umc.phrase.data.datasources.BookRemoteDataSource
import com.umc.phrase.data.model.BookEntity
import com.umc.phrase.remote.api.ApiService

class BookRemoteDataSourceImpl(
    private val apiService: ApiService
) : BookRemoteDataSource {
    override suspend fun searchBooks(query: String): List<BookEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getBook(id: Int): BookEntity {
        return apiService.getBookDetail(id).data.bookDetail.toData()
    }

    override suspend fun getBook(isbn: String): BookEntity {
        return apiService.getBookDetail(isbn).data.bookDetail.toData()
    }

    override suspend fun changeReadStatus(id: Int, readStatus: Boolean): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun changeReadStatus(isbn: String, readStatus: Boolean): Boolean {
        TODO("Not yet implemented")
    }

}