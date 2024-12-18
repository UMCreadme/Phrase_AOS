package com.umc.phrase.profile.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text

@Composable
fun ProfileTabs(
    tabs: List<String>,
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    content: @Composable (Int) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = selectedTab,
            modifier = Modifier.fillMaxWidth()
        ) {
            tabs.forEachIndexed { index, tabName ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { onTabSelected(index) }
                ) {
                    Text(
                        text = tabName,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

        content(selectedTab)
    }
}
