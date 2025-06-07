package com.andreising.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.andreising.domain.model.OptionMainModel
import com.andreising.domain.model.state.ResponseState

@Composable
fun MainScreen() {
    val viewModel: MainScreenViewModel = hiltViewModel()
    val responseState = viewModel.responseState.collectAsState(ResponseState.Loading)

    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

    MainContent(responseState = responseState.value)
}

@Composable
private fun MainContent(responseState: ResponseState) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when (responseState) {
            is ResponseState.Error -> ErrorState()
            is ResponseState.Loading -> LoadingState()
            is ResponseState.Success -> SuccessContent(list = responseState.data.optionList)
        }
    }
}

@Composable
private fun ErrorState() {
    Text("Error", color = Color.White)
}

@Composable
private fun LoadingState() {
    CircularProgressIndicator()
}

@Composable
private fun SuccessContent(list: List<OptionMainModel>) {
    val defaultHorizontalPadding = PaddingValues(horizontal = 16.dp)

    Column(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxSize()
    ) {
        MainScreenSearchBar(horizontalPadding = defaultHorizontalPadding)
        RecommendationBlock(list)
        VacanciesList()
    }
}

@Composable
fun VacanciesList() {

}