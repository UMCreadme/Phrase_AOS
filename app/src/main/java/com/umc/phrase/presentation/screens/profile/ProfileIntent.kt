package com.umc.phrase.presentation.screens.profile

sealed class ProfileIntent {
    object LoadProfile : ProfileIntent()
    data class SelectTab(val index: Int) : ProfileIntent()
}
