import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun ProfileInfoSection(
    profileImage: String,
    profileName: String,
    bio: String,
    followingCount: Int,
    followerCount: Int,
    onEditProfileClick: () -> Unit,
    onShareProfileClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 프로필 사진
        AsyncImage(
            model = profileImage,
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(8.dp))

        // 프로필 이름
        Text(text = profileName, style = MaterialTheme.typography.headlineSmall)

        // 소개글
        Text(
            text = bio,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        // 팔로워/팔로잉 수
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = followingCount.toString(), style = MaterialTheme.typography.headlineSmall)
                Text(text = "Following", style = MaterialTheme.typography.bodyMedium)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = followerCount.toString(), style = MaterialTheme.typography.headlineSmall)
                Text(text = "Followers", style = MaterialTheme.typography.bodyMedium)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // 프로필 편집 & 공유 버튼
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = onEditProfileClick) {
                Text("프로필 편집")
            }
            Button(onClick = onShareProfileClick) {
                Text("프로필 공유")
            }
        }
    }
}
