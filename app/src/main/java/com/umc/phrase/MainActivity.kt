package com.umc.phrase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.umc.phrase.presentation.screens.book.BookScreen
import com.umc.phrase.presentation.screens.book.BookViewModel
import com.umc.phrase.presentation.theme.PhraseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhraseTheme {
                BookScreen(viewModel)
            }
        }
    }
}