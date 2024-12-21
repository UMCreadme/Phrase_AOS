package com.umc.phrase.presentation.screens.profile

sealed class ProfileEvent {
    data class TabSelected(val tabIndex: Int) : ProfileEvent()
    object EditProfile : ProfileEvent()
    object ShareProfile : ProfileEvent()
}
