package com.umc.phrase.data.datasources

import com.umc.phrase.data.model.BookEntity

interface BookRemoteDataSource {
    suspend fun searchBooks(query: String): List<BookEntity>
    suspend fun getBook(id: Int): BookEntity
    suspend fun getBook(isbn: String): BookEntity
    suspend fun changeReadStatus(id: Int, readStatus: Boolean): Boolean
    suspend fun changeReadStatus(isbn: String, readStatus: Boolean): Boolean
}