package com.andreising.presentation.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.andreising.domain.model.OptionMainModel
import com.andreising.domain.model.VacancyMainModel
import com.andreising.domain.model.state.ResponseState
import com.andreising.presentation.R
import com.andreising.presentation.screens.main.components.MainScreenSearchBar
import com.andreising.presentation.screens.main.components.RecommendationBlock
import com.andreising.presentation.screens.main.components.VacancyCard

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
            is ResponseState.Success -> SuccessContent(
                optionList = responseState.data.optionList,
                vacancyList = responseState.data.vacancyList
            )
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
private fun SuccessContent(optionList: List<OptionMainModel>, vacancyList: List<VacancyMainModel>) {
    val defaultHorizontalPadding = PaddingValues(horizontal = 16.dp)

    LazyColumn(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { MainScreenSearchBar(horizontalPadding = defaultHorizontalPadding) }
        item { RecommendationBlock(optionList) }
        item { VacancyTitle() }
        items(vacancyList) {
            VacancyCard(
                vacancy = it,
                onFavouriteClicked = {},
                onClick = {})
        }
    }
}

@Composable
fun VacancyTitle(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.padding(horizontal = 16.dp),
        text = stringResource(R.string.vacancies_for_you),
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp
    )
}