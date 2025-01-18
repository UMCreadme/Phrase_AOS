package com.umc.phrase.data.datasources

import com.umc.phrase.data.model.BookEntity
import com.umc.phrase.data.model.PhraseEntity

interface BookRemoteDataSource {
    suspend fun searchBooks(query: String): List<BookEntity>
    suspend fun getBook(isbn: String): BookEntity
    suspend fun getPhrasePreviewsOfBook(isbn: String): List<PhraseEntity>
    suspend fun changeReadStatus(isbn: String, readStatus: Boolean): Boolean
}