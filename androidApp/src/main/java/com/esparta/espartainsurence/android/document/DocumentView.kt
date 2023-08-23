package com.esparta.espartainsurence.android.document

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.esparta.espartainsurence.android.MyApplicationTheme
import com.esparta.espartainsurence.android.commons.views.*
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DocumentView(
    text: String,
    toolbar: String,
    navHostController: NavHostController,
    viewModel: DocumentViewModel = koinViewModel()
) {
    val screenState = viewModel.sharedFlow.collectAsState(false)
    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            EspartaToolbar(toolbar, pressOnBack = { navHostController.popBackStack() }, scrollBehavior)
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(16.dp, 0.dp)
                    .verticalScroll(scrollState)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
            ) {
                DefaultSpacer()
                QuestionText(text = text)
                DefaultSpacer()
                DefaultSpacer()
                TextInputEsparta(
                    hint = text,
                    textInput = { text ->
                        viewModel.setButtonEnable(text)
                    }
                )
                DefaultSpacer()
                DefaultSpacer()
                ButtonEsparta(
                    isEnable = screenState.value
                ) {
                    navHostController.navigate("name")
                }
            }
        }
    )
}

@Preview
@Composable
fun DocumentViewPreview() {
    val navController = rememberNavController()
    MyApplicationTheme {
        DocumentView("Qual seu nome?", "name", navController)
    }
}