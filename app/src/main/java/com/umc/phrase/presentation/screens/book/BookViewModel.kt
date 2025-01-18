package com.umc.phrase.presentation.screens.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umc.phrase.domain.DataResource
import com.umc.phrase.domain.usecase.book.GetBookUseCase
import com.umc.phrase.domain.usecase.book.GetPhrasePreviewOfBookUseCase
import com.umc.phrase.presentation.screens.home.toPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val getBookUseCase: GetBookUseCase,
    private val getPhrasePreviewOfBookUseCase: GetPhrasePreviewOfBookUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(BookState.DEFAULT)
    val uiState = _uiState.asStateFlow()

    init {
        fetchBook("9791190090261")
    }

    private fun fetchBook(isbn: String) {
        viewModelScope.launch {
            getBookUseCase(isbn)
                .onCompletion {
                    _uiState.update { it.copy(isLoading = false) }
                }
                .collect { dataResource ->
                    when (dataResource) {
                        is DataResource.Success ->
                            _uiState.update { uiState ->
                                uiState.copy(book = dataResource.data.toPresentation())
                            }

                        is DataResource.Error -> _uiState.update { it.copy(error = dataResource.throwable) }
                        is DataResource.Loading -> _uiState.update { it.copy(isLoading = true) }
                    }
                }
            getPhrasePreviewOfBookUseCase(isbn)
                .onCompletion {
                    _uiState.update { it.copy(isLoading = false) }
                }
                .collect { dataResource ->
                    when (dataResource) {
                        is DataResource.Success ->
                            _uiState.update { uiState ->
                                uiState.copy(phrasePreview = dataResource.data.map { it.toPresentation() })
                            }

                        is DataResource.Error -> _uiState.update { it.copy(error = dataResource.throwable) }
                        is DataResource.Loading -> _uiState.update { it.copy(isLoading = true) }
                    }
                }
        }
    }
}