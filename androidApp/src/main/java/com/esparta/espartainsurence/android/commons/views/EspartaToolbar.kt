package com.esparta.espartainsurence.android.commons.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.esparta.espartainsurence.android.MyApplicationTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EspartaToolbar(
    text: String,
    pressOnBack: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        navigationIcon = {
            IconButton(onClick = { pressOnBack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description",
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

//@Preview
//@Composable
//fun EspartaToolbarPreview() {
//    MyApplicationTheme {
//        EspartaToolbar("text", pressOnBack = {})
//    }
//}