package com.umc.phrase.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Blue500,
    onPrimary = Blue50,
    primaryContainer = Blue200,
    onPrimaryContainer = Blue700,
    secondary = Purple500,
    onSecondary = Purple50,
    secondaryContainer = Purple200,
    onSecondaryContainer = Purple700,
    background = Gray50,
    onBackground = Gray900,
    surface = Gray100,
    onSurface = Gray700,
    surfaceVariant = Gray200,
    onSurfaceVariant = Gray500,
    outline = Gray300,
    error = Red500,
    onError = Red50,
    errorContainer = Red200,
    onErrorContainer = Red700
)

@Composable
fun PhraseTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}