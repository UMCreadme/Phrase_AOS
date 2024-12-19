package com.umc.phrase.profile.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umc.phrase.R
import com.umc.phrase.commons.ui.theme.PhraseTheme
import com.umc.phrase.profile.presentation.ProfileEvent
import com.umc.phrase.profile.presentation.ProfileViewModel

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
        Spacer(modifier = Modifier.height(16.dp))

        ProfileTabs(
            tabs = tabs,
            selectedTab = state.selectedTab,
            onTabSelected = { viewModel.onEvent(ProfileEvent.TabSelected(it)) },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    PhraseTheme {
        ProfileInfoSection(
            profileImage = "https://loremflickr.com/150/150",
            profileName = "Pearl",
            profileId = "pearl_k",
            bio = "compose Lover... It is a test string for long bio example",
            booksCount = 17,
            followingCount = 700,
            followerCount = 777,
            onEditProfileClick = { /* 프로필 편집 로직 추가 */ },
            onShareProfileClick = { /* 프로필 공유 로직 추가 */ }
        )

        val tabs = listOf(
            "myPhrases" to R.drawable.ic_phraselist,
            "likePhrases" to R.drawable.ic_likelist,
            "myBooks" to R.drawable.ic_booklist
        )

        var selectedTab by remember { mutableStateOf(0) }

        ProfileTabs(
            tabs = tabs,
            selectedTab = selectedTab,
            onTabSelected = { index -> selectedTab = index }
        )
    }
}

