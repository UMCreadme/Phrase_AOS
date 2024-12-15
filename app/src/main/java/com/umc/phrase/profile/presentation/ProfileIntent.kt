package com.umc.phrase.profile.presentation

sealed class ProfileIntent {
    object LoadProfile : ProfileIntent()
    data class SelectTab(val index: Int) : ProfileIntent()
}
