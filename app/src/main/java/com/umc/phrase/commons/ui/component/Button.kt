package com.umc.phrase.commons.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umc.phrase.commons.ui.theme.PhraseTheme

@Composable
fun BasicButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = false,
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.surfaceVariant,
        disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
        disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
    ),
    textStyle: TextStyle = MaterialTheme.typography.displayMedium
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(10.dp),
        colors = colors,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}

enum class DeleteButtonStyle {
    DEFAULT, HIGHLIGHTED
}

@Composable
fun SecondaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = false,
    onClick: () -> Unit
) {
    BasicButton(
        text = text,
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        textStyle = MaterialTheme.typography.titleMedium
    )
}

@Composable
fun DeleteButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: DeleteButtonStyle = DeleteButtonStyle.DEFAULT
) {
    val backgroundColor = when (style) {
        DeleteButtonStyle.DEFAULT -> MaterialTheme.colorScheme.surfaceVariant
        DeleteButtonStyle.HIGHLIGHTED -> MaterialTheme.colorScheme.errorContainer
    }

    val iconColor = when (style) {
        DeleteButtonStyle.DEFAULT -> MaterialTheme.colorScheme.onSurfaceVariant
        DeleteButtonStyle.HIGHLIGHTED -> MaterialTheme.colorScheme.error
    }

    Box(
        modifier = modifier
            .size(20.dp)
            .background(color = backgroundColor, shape = CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Delete",
            tint = iconColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BasicButtonPreview1() {
    PhraseTheme {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            BasicButton(
                text = "시작하기",
                enabled = false,
                onClick = {}
            )

            BasicButton(
                text = "시작하기",
                enabled = true,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BasicButtonPreview2() {
    PhraseTheme {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            BasicButton(
                text = "팔로잉",
                enabled = false,
                onClick = {},
                textStyle = MaterialTheme.typography.titleMedium
            )

            BasicButton(
                text = "팔로우",
                enabled = true,
                onClick = {},
                textStyle = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondaryButtonPreview1() {
    PhraseTheme {
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            SecondaryButton(
                text = "프로필 편집",
                enabled = true,
                onClick = {},
                modifier = Modifier.weight(1f)
            )

            SecondaryButton(
                text = "프로필 공유",
                enabled = true,
                onClick = {},
                modifier = Modifier.weight(1f)
            )
        }
    }
}
