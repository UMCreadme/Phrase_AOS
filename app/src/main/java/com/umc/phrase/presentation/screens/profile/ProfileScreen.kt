package com.umc.phrase.presentation.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umc.phrase.R
import com.umc.phrase.presentation.theme.PhraseTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel
) {
    val state by viewModel.uiState.collectAsState() // StateFlow를 통한 UI 상태를 구독

    val tabs = listOf(
        "My Phrases" to R.drawable.ic_phraselist,
        "Liked Phrases" to R.drawable.ic_likelist,
        "My Books" to R.drawable.ic_booklist
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileInfoSection(
            profileImage = state.profileImage,
            profileName = state.profileName,
            profileId = state.profileId,
            bio = state.bio,
            booksCount = state.bookCount,
            followingCount = state.followingCount,
            followerCount = state.followerCount,
            onEditProfileClick = { viewModel.onEvent(ProfileEvent.EditProfile) },
            onShareProfileClick = { viewModel.onEvent(ProfileEvent.ShareProfile) }
        )
        Spacer(modifier = Modifier.height(8.dp))

        ProfileTabs(
            tabs = tabs,
            selectedTab = state.selectedTab,
            onTabSelected = { viewModel.onEvent(ProfileEvent.TabSelected(it)) },
        )
    }
}

class PreviewProfileViewModel : ProfileViewModel() {
    private val previewState = ProfileState(
        profileImage = "https://loremflickr.com/150/150",
        profileName = "Pearl",
        profileId = "pearl_k",
        bio = "test bio for preview profile viewmodel",
        bookCount = 5,
        followingCount = 150,
        followerCount = 200,
        selectedTab = 1
    )

    override val uiState: StateFlow<ProfileState> = MutableStateFlow(previewState)

    override fun onEvent(event: ProfileEvent) {
        // 프리뷰용이므로 이벤트 처리 생략
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val previewViewModel = PreviewProfileViewModel()

    PhraseTheme {
        ProfileScreen(viewModel = previewViewModel)
    }
}




