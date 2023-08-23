package com.esparta.espartainsurence.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.esparta.espartainsurence.android.commons.views.SetStatusBarColor
import com.esparta.espartainsurence.android.document.DocumentView

@Composable
fun MainRoot() {
    val navController = rememberNavController()

    MyApplicationTheme {
//        SetStatusBarColor(color = MaterialTheme.colorScheme.surface)
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            NavHost(navController = navController, startDestination = "document") {
                composable("document") { DocumentView("Qual seu CPF?", "Documento", navController) }
                composable("name") { DocumentView("Qual seu nome?", "Nome", navController) }
            }
        }
    }
}