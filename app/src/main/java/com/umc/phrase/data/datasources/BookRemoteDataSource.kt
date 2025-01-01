package com.umc.phrase.data.datasources

import com.umc.phrase.data.model.BookEntity

interface BookRemoteDataSource {
    suspend fun searchBooks(query: String): List<BookEntity>
    suspend fun getBook(id: Int): BookEntity
    suspend fun changeReadStatus(id: Int, readStatus: Boolean): Boolean
}