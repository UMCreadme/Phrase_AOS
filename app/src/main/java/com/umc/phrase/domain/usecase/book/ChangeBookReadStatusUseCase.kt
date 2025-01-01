package com.umc.phrase.domain.usecase.book

import com.umc.phrase.domain.DataResource
import com.umc.phrase.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow

class ChangeBookReadStatusUseCase(
    private val bookRepository: BookRepository
) {
    operator fun invoke(id: Int, readStatus: Boolean): Flow<DataResource<Boolean>> =
        bookRepository.changeReadStatus(id, readStatus)
}