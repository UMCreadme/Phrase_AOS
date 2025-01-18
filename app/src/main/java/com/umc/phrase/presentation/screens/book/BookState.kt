package com.umc.phrase.presentation.screens.book

import com.umc.phrase.presentation.screens.home.PhrasePreviewModel

data class BookState(
    val isLoading: Boolean,
    val book: BookModel,
    val phrasePreview: List<PhrasePreviewModel>,
    val error: Throwable?,
) {
    companion object {
        val DEFAULT = BookState(
            isLoading = false,
            book = BookModel(
                isbn = "",
                title = "",
                author = "",
                coverImageUrl = "",
                readStatus = false,
                purchaseLink = "",
            ),
            phrasePreview = emptyList(),
            error = null
        )
    }
}