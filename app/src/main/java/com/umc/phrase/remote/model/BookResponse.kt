package com.umc.phrase.remote.model

import com.google.gson.annotations.SerializedName
import com.umc.phrase.data.model.BookEntity

data class BookDetailResponse(
    @SerializedName("bookId")
    val bookId: Int,
    @SerializedName("ISBN")
    val isbn: String,
    @SerializedName("bookCover")
    val bookCover: String,
    @SerializedName("bookTitle")
    val bookTitle: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("link")
    val purchaseLink: String,
    @SerializedName("isRead")
    val readStatus: Boolean,
) : RemoteMapper<BookEntity> {
    override fun toData(): BookEntity = BookEntity(
        id = bookId,
        title = bookTitle,
        author = author,
        coverImageUrl = bookCover,
        readStatus = readStatus,
        purchaseLink = purchaseLink,
    )
}