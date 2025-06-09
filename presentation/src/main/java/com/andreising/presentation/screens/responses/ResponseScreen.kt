package com.andreising.presentation.screens.responses

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.andreising.presentation.theme.GrayBasic

@Composable
fun ResponseScreen() {
    Text(
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center,
        text = "Отклики",
        color = GrayBasic
    )
}