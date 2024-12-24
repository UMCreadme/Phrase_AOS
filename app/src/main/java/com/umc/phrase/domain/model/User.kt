package com.umc.phrase.domain.model

data class User (
    val id: Long,
    val nickname: String,
    val accountId: String,
    val profileImgUrl: String?
)