package com.esparta.espartainsurence.android.document

sealed class DocumentViewAction {
    object LoadFavorite : DocumentViewAction()
    data class DeleteItem(val id: Int) : DocumentViewAction()
}