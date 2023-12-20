package com.esparta.espartainsurence.android.document

data class DocumentViewState(
    val isLoading: Boolean = false,
    val isButtonEnable: Boolean = false,
    val address: String = "empty",
)