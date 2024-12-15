package com.umc.phrase.profile.presentation

data class ProfileViewState(
    val isLoading: Boolean = true,
    val profileImage: String = "",
    val profileName: String = "",
    val bio: String = "",
    val followingCount: Int = 0,
    val followerCount: Int = 0,
    val selectedTab: Int = 0
)
