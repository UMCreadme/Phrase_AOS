package com.umc.phrase.remote.datasources

import com.umc.phrase.data.datasources.BookRemoteDataSource
import com.umc.phrase.data.model.BookEntity
import com.umc.phrase.data.model.PhraseEntity
import com.umc.phrase.remote.api.ApiService
import javax.inject.Inject

class BookRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : BookRemoteDataSource {
    override suspend fun searchBooks(query: String): List<BookEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getBook(isbn: String): BookEntity {
        return apiService.getBookDetail(isbn).data.bookDetail.toData()
    }

    override suspend fun getPhrasePreviewsOfBook(isbn: String): List<PhraseEntity> {
        return apiService.getBookDetail(isbn).data.phrasePreview.map { it.toData() }
    }

    override suspend fun changeReadStatus(isbn: String, readStatus: Boolean): Boolean {
        TODO("Not yet implemented")
    }

}