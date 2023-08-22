package com.esparta.espartainsurence.android.document

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.esparta.espartainsurence.android.MyApplicationTheme
import com.esparta.espartainsurence.android.commons.views.*
import org.koin.androidx.compose.koinViewModel

@Composable
fun DocumentView(
    text: String,
    toolbar: String,
    navHostController: NavHostController,
    viewModel: DocumentViewModel = koinViewModel()
) {
    val screenState = viewModel.sharedFlow.collectAsState(false)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
    ) {
        EspartaToolbar(toolbar, pressOnBack = { navHostController.popBackStack() })
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            DefaultSpacer()
            QuestionText(text = text)
            DefaultSpacer()
            DefaultSpacer()
            TextInputEsparta(
                hint = text,
                textInput = {
                    viewModel.setButtonEnable(it)
                }
            )
            DefaultSpacer()
            ButtonEsparta(
                isEnable = screenState.value
            ) {
                navHostController.navigate("name")
            }
        }
    }
}

@Preview
@Composable
fun DocumentViewPreview() {
    val navController = rememberNavController()
    MyApplicationTheme {
        DocumentView("Qual seu nome?", "name", navController)
    }
}