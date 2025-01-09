package com.umc.phrase.domain.usecase.book

import com.umc.phrase.domain.DataResource
import com.umc.phrase.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChangeBookReadStatusUseCase @Inject constructor(
    private val bookRepository: BookRepository
) {
    operator fun invoke(isbn: String, readStatus: Boolean): Flow<DataResource<Boolean>> =
        bookRepository.changeReadStatus(isbn, readStatus)
}