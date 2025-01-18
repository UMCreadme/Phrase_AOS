package com.umc.phrase.domain.usecase.book

import com.umc.phrase.domain.DataResource
import com.umc.phrase.domain.model.Book
import com.umc.phrase.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow

class SearchBookUseCase(
    private val bookRepository: BookRepository
) {
    operator fun invoke(query: String): Flow<DataResource<List<Book>>> =
        bookRepository.searchBooks(query)
}