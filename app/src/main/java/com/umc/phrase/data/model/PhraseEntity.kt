package com.umc.phrase.data.model

import com.umc.phrase.domain.model.Phrase

data class PhraseEntity(
    val id: Int,
    val title: String,
    val author: String,
    val imageUrl: String,
    val content: String,
) : DataMapper<Phrase> {
    override fun toDomain(): Phrase = Phrase(
        id = id,
        title = title,
        author = author,
        imageUrl = imageUrl,
        content = content,
    )
}
