package com.umc.phrase.profile.presentation

sealed class ProfileEvent {
    data class TabSelected(val tabIndex: Int) : ProfileEvent()
    object EditProfile : ProfileEvent()
    object ShareProfile : ProfileEvent()
}
