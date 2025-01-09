package com.umc.phrase.presentation.screens.home

import com.umc.phrase.domain.model.Phrase

data class PhrasePreviewModel(
    val id: Int,
//    val title: String,
//    val author: String,
    val imageUrl: String,
    val content: String,
    val isLike: Boolean = false
)

fun Phrase.toPresentation(): PhrasePreviewModel =
    PhrasePreviewModel(id, imageUrl, content, isLike)
