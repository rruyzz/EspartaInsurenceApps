package com.esparta.espartainsurence.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.esparta.espartainsurence.android.document.DocumentView

@Composable
fun MainRoot() {
    val navController = rememberNavController()

    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            NavHost(navController = navController, startDestination = "document") {
                composable("document") { DocumentView("Qual seu CEP?", "CEP", navController) }
                composable("name") { DocumentView("Qual seu nome?", "Nome", navController) }
            }
        }
    }
}