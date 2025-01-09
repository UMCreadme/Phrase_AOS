package com.umc.phrase.domain.model

data class Phrase(
    val id: Int,
    val title: String,
    val author: String,
    val imageUrl: String,
    val content: String,
)
