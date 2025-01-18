package com.umc.phrase.domain.model

data class User (
    val id: Long,
    val nickname: String,
    val accountId: String,
    val profileImgUrl: String?
)

data class UserDetail(
    val user: User,
    val followers: Long,
    val followings: Long,
    val comment: String?
)