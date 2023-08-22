package com.esparta.espartainsurence.android.commons.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun TextInputEsparta(hint: String, textInput: (String) -> Unit) {
    val text = remember { mutableStateOf("")  }
    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = text.value,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = {
            text.value = it
            textInput(text.value)
        },
        label = { Text(text = hint) },
        placeholder = { Text(text = hint) },
    )
}