package com.umc.phrase.remote.model

import com.google.gson.annotations.SerializedName
import com.umc.phrase.data.model.PhraseEntity

data class PhrasePreviewResponse(
    @SerializedName("shortsId")
    val phraseId: Int,
    @SerializedName("shortsImg")
    val phraseImg: String,
    @SerializedName("phrase")
    val phrase: String,
) : RemoteMapper<PhraseEntity> {
    override fun toData(): PhraseEntity = PhraseEntity(
        id = phraseId,
        title = "",
        author = "",
        imageUrl = phraseImg,
        content = phrase,
    )
}