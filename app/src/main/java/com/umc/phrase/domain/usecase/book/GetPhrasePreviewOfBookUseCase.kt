package com.umc.phrase.domain.usecase.book

import com.umc.phrase.domain.DataResource
import com.umc.phrase.domain.model.Phrase
import com.umc.phrase.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPhrasePreviewOfBookUseCase @Inject constructor(
    private val bookRepository: BookRepository
) {
    operator fun invoke(isbn: String): Flow<DataResource<List<Phrase>>> = bookRepository.getPhrasePreviewsOfBook(isbn)
}