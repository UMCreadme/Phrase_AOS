package com.umc.phrase.presentation.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.umc.phrase.presentation.components.SecondaryButton
import com.umc.phrase.presentation.theme.PhraseTheme

@Composable
fun ProfileInfoSection(
    profileImage: String,
    profileName: String,
    profileId: String,
    bio: String,
    booksCount: Int,
    followingCount: Int,
    followerCount: Int,
    onEditProfileClick: () -> Unit,
    onShareProfileClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // 프로필 사진
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = profileImage,
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(66.dp)
                        .clip(CircleShape)
                )
            }

            // 읽은 책, 팔로잉, 팔로워
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 60.dp, end = 10.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = booksCount.toString(),
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(text = "읽은 책", style = MaterialTheme.typography.bodyMedium)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = followingCount.toString(),
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(text = "팔로잉", style = MaterialTheme.typography.bodyMedium)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = followerCount.toString(),
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(text = "팔로워", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
        ){

            Column(horizontalAlignment = Alignment.Start) {
                // 프로필 이름
                Text(
                    text = profileName,
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(4.dp))

                // 프로필 ID
                Text(
                    text = "@$profileId",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))

                // 소개글
                Text(
                    text = bio,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // 프로필 편집 & 공유 버튼
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            SecondaryButton(
                text = "프로필 편집",
                onClick = onEditProfileClick,
                modifier = Modifier.weight(1f),
                enabled = true
            )
            Spacer(modifier = Modifier.width(10.dp))

            SecondaryButton(
                text = "프로필 공유",
                onClick = onShareProfileClick,
                modifier = Modifier.weight(1f),
                enabled = true
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileInfoSectionPreview() {
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
    }
}
