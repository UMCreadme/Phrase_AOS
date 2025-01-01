package com.umc.phrase.domain.repository

import com.umc.phrase.domain.DataResource
import com.umc.phrase.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun searchBooks(query: String): Flow<DataResource<List<Book>>>
    fun getBook(id: Int): Flow<DataResource<Book>>
    fun changeReadStatus(id: Int, readStatus: Boolean): Flow<DataResource<Boolean>>
}