package com.andreising.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreising.presentation.theme.MainBlack

@Composable
fun MainScreen() {
    val defaultHorizontalPadding = PaddingValues(horizontal = 16.dp)
    Column(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxSize()
    ) {
        MainScreenSearchBar(horizontalPadding = defaultHorizontalPadding)
    }

    RecommendationBlock()
    VacanciesList()
}

@Composable
fun VacanciesList() {

}

@Composable
fun RecommendationBlock() {

}

@Preview
@Composable
fun MainScreenPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBlack)
    ) {
        MainScreen()
    }
}