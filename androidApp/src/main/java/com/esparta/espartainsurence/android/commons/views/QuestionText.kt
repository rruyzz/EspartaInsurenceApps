package com.esparta.espartainsurence.android.commons.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun QuestionText(text: String) {
    Text(
        text = text,
        modifier = Modifier.fillMaxWidth(),
        color = Color.Black,
        fontSize = 21.sp
    )
}