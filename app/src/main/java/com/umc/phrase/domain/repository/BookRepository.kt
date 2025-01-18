package com.umc.phrase.domain.repository

import com.umc.phrase.domain.DataResource
import com.umc.phrase.domain.model.Book
import com.umc.phrase.domain.model.Phrase
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun searchBooks(query: String): Flow<DataResource<List<Book>>>
    fun getBook(isbn: String): Flow<DataResource<Book>>
    fun getPhrasePreviewsOfBook(isbn: String): Flow<DataResource<List<Phrase>>>
    fun changeReadStatus(isbn: String, readStatus: Boolean): Flow<DataResource<Boolean>>
}