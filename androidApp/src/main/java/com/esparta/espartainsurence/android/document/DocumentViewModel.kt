package com.esparta.espartainsurence.android.document

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DocumentViewModel(): ViewModel() {

//    private val _isButtonEnable = MutableStateFlow(false)
//    val isButtonEnable = _isButtonEnable.asStateFlow()
//    val issButtonEnable = false.stateIn()
    private val _sharedFlow = MutableSharedFlow<Boolean>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun setButtonEnable(text: String) = viewModelScope.launch {
//        _isButtonEnable.emit(text.length > 4)
//        issButtonEnable = text.length > 4
        _sharedFlow.emit(text.length == 11)
    }

}