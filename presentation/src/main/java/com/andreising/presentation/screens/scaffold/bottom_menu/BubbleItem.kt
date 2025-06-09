package com.andreising.presentation.screens.scaffold.bottom_menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BubbleItem(count: Int, modifier: Modifier = Modifier) {
    val bubbleSize = 12.dp
    Box(
        modifier = modifier
            .size(bubbleSize)
            .clip(CircleShape)
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) { Text(text = count.toString(), color = Color.White, fontSize = 7.sp) }
}