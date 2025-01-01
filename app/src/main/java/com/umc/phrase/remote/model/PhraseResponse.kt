package com.umc.phrase.remote.model

import com.google.gson.annotations.SerializedName

// TODO: Phrase data 레이어 정의된 후 RemoteMapper 임플하기
data class PhrasePreviewResponse(
    @SerializedName("shortsId")
    val phraseId: Int,
    @SerializedName("shortsImg")
    val phraseImg: String,
    @SerializedName("phrase")
    val phrase: String,
)