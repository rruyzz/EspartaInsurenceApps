package com.esparta.espartainsurence.android.document

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esparta.espartainsurence.domain.usecase.CepUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DocumentViewModel(
    private val getAddress: CepUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DocumentViewState())
    val uiState = _uiState.asStateFlow()

    fun getAddress() = viewModelScope.launch {
        _uiState.emit(uiState.value.copy(isLoading = true))
        getAddress.invoke("cep")
            .onStart { _uiState.emit(uiState.value.copy(isLoading = true)) }
            .onCompletion { _uiState.emit(uiState.value.copy(isLoading = false)) }
            .collect { _uiState.emit(uiState.value.copy(address = it)) }
    }

    fun setButtonEnable(text: String) = viewModelScope.launch {
        _uiState.emit(uiState.value.copy(isButtonEnable = text.length == 8))
    }

}