package com.umc.phrase.presentation.screens.book

import com.umc.phrase.domain.model.Book

data class BookModel(
    val isbn: String,
    val title: String,
    val author: String,
    val coverImageUrl: String,
    val readStatus: Boolean,
    val purchaseLink: String,
)

fun Book.toPresentation(): BookModel =
    BookModel(isbn, title, author, coverImageUrl, readStatus, purchaseLink)
