package com.andreising.presentation.screens.profile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.andreising.presentation.theme.GrayBasic

@Composable
fun ProfileScreen() {
    Text(
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center,
        text = "Профиль",
        color = GrayBasic
    )
}