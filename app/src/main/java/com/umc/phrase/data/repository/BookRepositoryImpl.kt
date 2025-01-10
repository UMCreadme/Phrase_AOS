package com.umc.phrase.data.repository

import com.umc.phrase.data.datasources.BookRemoteDataSource
import com.umc.phrase.domain.DataResource
import com.umc.phrase.domain.model.Book
import com.umc.phrase.domain.model.Phrase
import com.umc.phrase.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val bookRemoteDataSource: BookRemoteDataSource
) : BookRepository {
    override fun searchBooks(query: String): Flow<DataResource<List<Book>>> = flow {
        emit(DataResource.loading())
        try {
            val books = bookRemoteDataSource.searchBooks(query).map { it.toDomain() }
            emit(DataResource.success(books))
        } catch (e: Exception) {
            emit(DataResource.error(e))
        }
    }

    override fun getBook(isbn: String): Flow<DataResource<Book>> = flow {
        emit(DataResource.loading())
        try {
            val book = bookRemoteDataSource.getBook(isbn).toDomain()
            emit(DataResource.success(book))
        } catch (e: Exception) {
            emit(DataResource.error(e))
        }
    }

    override fun getPhrasePreviewsOfBook(isbn: String): Flow<DataResource<List<Phrase>>> = flow {
        emit(DataResource.loading())
        try {
            val phrases = bookRemoteDataSource.getPhrasePreviewsOfBook(isbn).map { it.toDomain() }
            emit(DataResource.success(phrases))
        } catch (e: Exception) {
            emit(DataResource.error(e))
        }
    }

    override fun changeReadStatus(isbn: String, readStatus: Boolean): Flow<DataResource<Boolean>> =
        flow {
            emit(DataResource.loading())
            try {
                val result = bookRemoteDataSource.changeReadStatus(isbn, readStatus)
                emit(DataResource.success(result))
            } catch (e: Exception) {
                emit(DataResource.error(e))
            }
        }
}