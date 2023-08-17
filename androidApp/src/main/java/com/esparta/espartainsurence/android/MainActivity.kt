package com.esparta.espartainsurence.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.esparta.espartainsurence.android.commons.views.DefaultSpacer
import com.esparta.espartainsurence.android.commons.views.EspartaToolbar
import com.esparta.espartainsurence.android.commons.views.QuestionText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainRoot()
//            MyApplicationTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    GreetingView(Greeting().greet())
//                }
//            }
        }
    }
}

@Composable
fun GreetingView(text: String, navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.Top,
    ) {
        EspartaToolbar("Toolbar", pressOnBack = { navHostController.popBackStack() })
        DefaultSpacer()
        QuestionText(text = text)
        DefaultSpacer()
        Button(onClick = {
            navHostController.navigate("list")
        }) {
            Text("Go to Next")
        }
    }
}

@Composable
fun GreetingOutroView(text: String, navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        EspartaToolbar("Toolbar", pressOnBack = { navHostController.popBackStack() })
        Text(text = text)
        Text(text = text)
    }

}
