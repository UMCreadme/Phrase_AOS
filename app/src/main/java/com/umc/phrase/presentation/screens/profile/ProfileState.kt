package com.umc.phrase.presentation.screens.profile

data class ProfileState(
    val isLoading: Boolean = true,
    val profileImage: String = "",
    val profileName: String = "",
    val profileId: String = "",
    val bio: String = "",
    val bookCount: Int = 0,
    val followingCount: Int = 0,
    val followerCount: Int = 0,
    val selectedTab: Int = 0
)
