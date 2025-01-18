package com.umc.phrase.presentation.screens.book

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.umc.phrase.presentation.components.PhraseCardView
import com.umc.phrase.presentation.components.SecondaryButton
import com.umc.phrase.presentation.screens.home.PhrasePreviewModel
import com.umc.phrase.presentation.theme.PhraseTheme

@Composable
fun BookScreen(viewModel: BookViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            snackbarHostState.showSnackbar(it)
            errorMessage = null
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            BookInfo(uiState.book)
            PhraseList(uiState.phrasePreview)
            if (uiState.isLoading) {
                CircularProgressIndicator()
            }
            if (uiState.error != null) {
                errorMessage = "오류발생: ${uiState.error}"

            }
        }
    }
}

@Composable
private fun BookInfo(book: BookModel) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(horizontal = 20.dp)
        ) {
            AsyncImage(
                model = book.coverImageUrl,
                contentDescription = "Book Cover Image",
                modifier = Modifier
                    .height(210.dp)
                    .align(Alignment.Center),
            )

            // TODO: 읽음 버튼
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.surface)
                .border(width = 1.dp, color = MaterialTheme.colorScheme.surfaceVariant)
                .padding(horizontal = 24.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(2f),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                // 책 제목
                Text(
                    text = book.title,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 1,
                    modifier = Modifier.padding(top = 8.dp)
                )

                // 책 저자
                Text(
                    text = book.author,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            SecondaryButton(
                text = "구매하기",
                onClick = { /* 구매하기 클릭 처리 */ },
                enabled = true,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
private fun PhraseList(phrases: List<PhrasePreviewModel>) {
    if (phrases.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "등록된 phrase가 없습니다.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 7.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = "phrase",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(phrases.size) { index ->
                    PhraseCardView(
                        phrase = phrases[index],
                        gradientColors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.primaryContainer
                        ),
                        height = 210,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookInfoPreview() {
    PhraseTheme {
        val book = BookModel(
            "isbn",
            "아무것도 없는 책",
            "레미 쿠르종 글/그림     이성엽 옮김",
            "https://image.aladin.co.kr/product/35431/88/cover200/k022035739_1.jpg",
            false,
            "https://www.google.com"
        )
        BookInfo(book)
    }
}

@Preview(showBackground = true)
@Composable
fun PhraseListPreview() {
    PhraseTheme {
        val phrases = listOf(
            PhrasePreviewModel(
                1,
                "안녕하세요",
                "당신이라고 믿는 게 당신의 전부가 아닙니다.\n" +
                        "\n" +
                        "당신은 누구인가요.\n" +
                        "\n" +
                        "당신이 진정 누구인지 기억할 수 있나요?",
            ),
            PhrasePreviewModel(
                1,
                "안녕하세요",
                "당신이라고 믿는 게 당신의 전부가 아닙니다.\n" +
                        "\n" +
                        "당신은 누구인가요.\n" +
                        "\n" +
                        "당신이 진정 누구인지 기억할 수 있나요?",
            ),
            PhrasePreviewModel(
                1,
                "안녕하세요",
                "당신이라고 믿는 게 당신의 전부가 아닙니다.\n" +
                        "\n" +
                        "당신은 누구인가요.\n" +
                        "\n" +
                        "당신이 진정 누구인지 기억할 수 있나요?",
            ),
            PhrasePreviewModel(
                1,
                "안녕하세요",
                "당신이라고 믿는 게 당신의 전부가 아닙니다.\n" +
                        "\n" +
                        "당신은 누구인가요.\n" +
                        "\n" +
                        "당신이 진정 누구인지 기억할 수 있나요?",
            ),
        )
        PhraseList(phrases)
    }
}
