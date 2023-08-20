package com.esparta.espartainsurence.android.document

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.esparta.espartainsurence.android.commons.views.DefaultSpacer
import com.esparta.espartainsurence.android.commons.views.EspartaToolbar
import com.esparta.espartainsurence.android.commons.views.QuestionText

@Composable
fun DocumentView(text: String, toolbar:String, navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.Top,
    ) {
        EspartaToolbar(toolbar, pressOnBack = { navHostController.popBackStack() })
        DefaultSpacer()
        QuestionText(text = text)
        DefaultSpacer()
        Button(onClick = {
            navHostController.navigate("nome")
        }) {
            Text("Próximo")
        }
    }
}