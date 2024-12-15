package com.umc.phrase.profile.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class ProfileViewModel () : ViewModel() {

    private val _viewState = MutableStateFlow(ProfileViewState())
    val viewState: StateFlow<ProfileViewState> = _viewState

   // 내부 로직 추후 추가

    private fun selectTab(index: Int) {
        _viewState.value = _viewState.value.copy(selectedTab = index)
    }
}