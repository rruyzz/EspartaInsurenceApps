package com.esparta.espartainsurence.android.commons.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonEsparta(isEnable: Boolean = false, onClick: () -> Unit) {
    FilledTonalButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        onClick = {
            onClick.invoke()
        },
        enabled = isEnable,
    ) {
        Text("Próximo")
    }
}