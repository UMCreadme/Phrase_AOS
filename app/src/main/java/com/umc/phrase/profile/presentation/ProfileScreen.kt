package com.umc.phrase.profile.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.umc.phrase.profile.presentation.component.ProfileTabs
import com.umc.phrase.profile.presentation.component.ProfileInfoSection

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel
) {
    //val viewState by viewModel.viewState.collectAsState()

    // 프로필 화면 전체 구성
    /*Column(modifier = Modifier.fillMaxSize()) {

        // 프로필 상단 InfoSection
        ProfileInfoSection (
            profileImage = viewState.profileImage,
            profileName = viewState.profileName,
            profileId = viewState.profileId,
            bio = viewState.bio,
            booksCount = viewState.booksCount,
            followingCount = viewState.followingCount,
            followerCount = viewState.followerCount,
            onEditProfileClick = {  편집 로직  },
            onShareProfileClick = {  공유 로직  }
        )

        Spacer(modifier = Modifier.height(16.dp))*/

        // Tab Layout
        /*ProfileTabs(
            tabs = listOf("Posts", "Likes", "Comments"),
            selectedTab = viewState.selectedTab,
            onTabSelected = { index ->
                viewModel.handleIntent(ProfileIntent.SelectTab(index))
            }
        ) { selectedTab ->
            when (selectedTab) {
                0 -> LazyColumn {
                    items(viewState.posts) { post ->
                        PhraseCard(title = post.title, description = post.description)
                    }
                }
                1 -> LazyColumn {
                    items(viewState.likes) { like ->
                        PhraseCard(title = like.title, description = like.description)
                    }
                }
                2 -> LazyColumn {
                    items(viewState.comments) { comment ->
                        PhraseCard(title = comment.title, description = comment.description)
                    }
                }
            }
        }*/
    //}
}
