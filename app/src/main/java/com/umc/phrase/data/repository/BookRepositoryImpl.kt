package com.umc.phrase.data.repository

import com.umc.phrase.data.datasources.BookRemoteDataSource
import com.umc.phrase.domain.DataResource
import com.umc.phrase.domain.model.Book
import com.umc.phrase.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BookRepositoryImpl(
    private val bookRemoteDataSource: BookRemoteDataSource
) : BookRepository {
    override fun searchBooks(query: String): Flow<DataResource<List<Book>>> = flow {
        emit(DataResource.loading())
        try {
            val books = bookRemoteDataSource.searchBooks(query).map { it.toDomain() }
            emit(DataResource.Success(books))
        } catch (e: Exception) {
            emit(DataResource.Error(e))
        }
    }

    override fun getBook(id: Int): Flow<DataResource<Book>> = flow {
        emit(DataResource.loading())
        try {
            val book = bookRemoteDataSource.getBook(id).toDomain()
            emit(DataResource.Success(book))
        } catch (e: Exception) {
            emit(DataResource.Error(e))
        }
    }

    override fun getBook(isbn: String): Flow<DataResource<Book>> = flow {
        emit(DataResource.loading())
        try {
            val book = bookRemoteDataSource.getBook(isbn).toDomain()
            emit(DataResource.Success(book))
        } catch (e: Exception) {
            emit(DataResource.Error(e))
        }
    }

    override fun changeReadStatus(id: Int, readStatus: Boolean): Flow<DataResource<Boolean>> =
        flow {
            emit(DataResource.loading())
            try {
                val result = bookRemoteDataSource.changeReadStatus(id, readStatus)
                emit(DataResource.Success(result))
            } catch (e: Exception) {
                emit(DataResource.Error(e))
            }
        }

    override fun changeReadStatus(isbn: String, readStatus: Boolean): Flow<DataResource<Boolean>> =
        flow {
            emit(DataResource.loading())
            try {
                val result = bookRemoteDataSource.changeReadStatus(isbn, readStatus)
                emit(DataResource.Success(result))
            } catch (e: Exception) {
                emit(DataResource.Error(e))
            }
        }
}