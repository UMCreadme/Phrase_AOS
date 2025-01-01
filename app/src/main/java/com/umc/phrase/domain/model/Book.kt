package com.umc.phrase.domain.model

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val coverImageUrl: String,
    val readStatus: Boolean,
    val purchaseLink: String,
)