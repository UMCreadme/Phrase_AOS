package com.umc.phrase.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umc.phrase.presentation.screens.home.PhrasePreviewModel
import com.umc.phrase.presentation.theme.PhraseTheme

@Composable
fun PhraseCardView(
    phrase: PhrasePreviewModel,
    gradientColors: List<Color>,
    height: Int,
    width: Int? = null
) {
    val modifier = if (width != null) {
        Modifier.width(width.dp)
    } else {
        Modifier.fillMaxWidth()
    }
    ElevatedCard(
        modifier = modifier.height(height.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = gradientColors
                    )
                )
        ) {
            Column {
                Text(
                    text = phrase.content,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(12.dp)
                )

                // TODO: Add author and title

            }

            LikeButton(
                isLiked = phrase.isLike,
                onClick = { /* TODO: Handle like button click */ },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(6.dp),
                size = 24
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhraseCardViewPreview() {
    PhraseTheme {
        PhraseCardView(
            phrase = PhrasePreviewModel(
                id = 1,
                imageUrl = "https://images.unsplash.com/photo-1632210006857-7b3b3b3b3b3b",
                content = "The best way to predict the future is to create it.",
                isLike = false
            ),
            gradientColors = listOf(
                MaterialTheme.colorScheme.primary,
                MaterialTheme.colorScheme.primaryContainer
            ),
            width = 114,
            height = 164,
        )
    }
}