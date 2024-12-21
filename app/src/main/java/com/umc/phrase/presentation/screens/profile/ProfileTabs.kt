package com.umc.phrase.presentation.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.umc.phrase.R
import com.umc.phrase.presentation.theme.PhraseTheme

@Composable
fun ProfileTabs(
    tabs: List<Pair<String, Int>>, // <tabname, icon> pair
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    TabRow(
        selectedTabIndex = selectedTab,
        modifier = Modifier.fillMaxWidth()
    ) {
        tabs.forEachIndexed { index, tab ->
            val isSelected = selectedTab == index
            Tab(
                selected = isSelected,
                onClick = { onTabSelected(index) }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Icon(
                        painter = painterResource(id = tab.second), // 리소스 ID로 아이콘 로드
                        contentDescription = tab.first,
                        tint = if (isSelected) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileTabsWithIconsPreview() {
    PhraseTheme {
        val tabs = listOf(
            "myPhrases" to R.drawable.ic_phraselist,
            "likePhrases" to R.drawable.ic_likelist,
            "myBooks" to R.drawable.ic_booklist
        )

        // 상태 관리를 통한 Tab 선택 preview에 보이게 만들기
        var selectedTab by remember { mutableStateOf(0) }

        ProfileTabs(
            tabs = tabs,
            selectedTab = selectedTab,
            onTabSelected = { index -> selectedTab = index }
        )
    }
}

