package com.esparta.espartainsurence.android.document

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    val uiState by viewModel.uiState.collectAsState()

    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            EspartaToolbar(
                toolbar,
                pressOnBack = { navHostController.popBackStack() },
                scrollBehavior
            )
        },
        content = { padding ->
            with(uiState) {
                LoadingDocument(isLoading)
                DocumentSuccessView(
                    isLoading = isLoading,
                    scrollState = scrollState,
                    text = text,
                    textState = address,
                    onTextChanged = { viewModel.setButtonEnable(it) },
                    paddingValues = padding,
                    isEnable = isButtonEnable,
                    onClick = {
                        viewModel.getAddress()
                    }
                )
            }
        }
    )
}

@Composable
fun DocumentSuccessView(
    isLoading: Boolean,
    scrollState: ScrollState,
    text: String,
    textState: String,
    paddingValues: PaddingValues,
    onTextChanged: (String) -> Unit,
    isEnable: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        if (isLoading.not()) {
            DocumentBoxView(
                scrollState = scrollState,
                text = text,
                textState = textState,
                onTextChanged = { textInput ->
                    onTextChanged(textInput)
                },
                paddingValues = paddingValues,
            )
            ButtonDocument(
                isEnable = isEnable,
                onClick = {
                    onClick.invoke()
                }
            )
        }
    }
}

@Composable
fun DocumentBoxView(
    scrollState: ScrollState,
    text: String,
    textState: String,
    paddingValues: PaddingValues,
    onTextChanged: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
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
            textInput = { textInput ->
                onTextChanged(textInput)
            }
        )
        QuestionText(text = textState)
        DefaultSpacer()
        DefaultSpacer()
    }
}

@Composable
fun ButtonDocument(isEnable: Boolean, onClick: () -> Unit) {
    ButtonEsparta(
        isEnable = isEnable
    ) {
        onClick.invoke()
    }
}

@Composable
fun LoadingDocument(isLoading: Boolean) {
    if (isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(32.dp),
                color = Color.White,
            )
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