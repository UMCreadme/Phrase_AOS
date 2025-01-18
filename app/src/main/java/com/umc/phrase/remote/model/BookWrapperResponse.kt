package com.umc.phrase.remote.model

import com.google.gson.annotations.SerializedName

data class BookDetailWrapperResponse(
    @SerializedName("book")
    val bookDetail: BookDetailResponse,
    @SerializedName("shorts")
    val phrasePreview: List<PhrasePreviewResponse>,
)