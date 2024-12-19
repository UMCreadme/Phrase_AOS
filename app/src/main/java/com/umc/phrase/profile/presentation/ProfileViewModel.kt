package com.umc.phrase.profile.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileState())
    val uiState: StateFlow<ProfileState> = _uiState

    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.TabSelected -> {
                _uiState.update { it.copy(selectedTab = event.tabIndex) }
            }
            ProfileEvent.EditProfile -> {
                // 프로필 편집 로직
            }
            ProfileEvent.ShareProfile -> {
                // 프로필 공유 로직
            }
        }
    }
}
