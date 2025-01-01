package com.umc.phrase.data.model

import com.umc.phrase.domain.model.Book

data class BookEntity(
    val id: Int,
    val title: String,
    val author: String,
    val coverImageUrl: String,
    val readStatus: Boolean,
    val purchaseLink: String,
) : DataMapper<Book> {
    override fun toDomain(): Book = Book(
        id = id,
        title = title,
        author = author,
        coverImageUrl = coverImageUrl,
        readStatus = readStatus,
        purchaseLink = purchaseLink,
    )
}
