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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.andreising.presentation.screens.main.components.BigPrimaryButton
import com.andreising.presentation.screens.main.components.MainScreenSearchBar
import com.andreising.presentation.screens.main.components.RecommendationBlock
import com.andreising.presentation.screens.main.components.VacancyCard
import com.andreising.presentation.screens.main.components.VacancyTopRow

@Composable
fun MainScreen(onNavigateToVacancyScreen: () -> Unit) {
    val viewModel: MainScreenViewModel = hiltViewModel()
    val responseState = viewModel.responseState.collectAsState(ResponseState.Loading)

    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

    MainContent(
        responseState = responseState.value,
        onItemFavouriteToggled = { viewModel.toggleItem(it) },
        onNavigateToVacancyScreen = { onNavigateToVacancyScreen.invoke() }
    )
}

@Composable
private fun MainContent(
    responseState: ResponseState,
    onItemFavouriteToggled: (VacancyMainModel) -> Unit,
    onNavigateToVacancyScreen: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when (responseState) {
            is ResponseState.Error -> ErrorState()
            is ResponseState.Loading -> LoadingState()
            is ResponseState.Success -> SuccessContent(
                optionList = responseState.data.optionList,
                vacancyList = responseState.data.vacancyList,
                onItemFavouriteToggled = { onItemFavouriteToggled.invoke(it) },
                onNavigateToVacancyScreen = { onNavigateToVacancyScreen.invoke() }
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
private fun SuccessContent(
    optionList: List<OptionMainModel>,
    vacancyList: List<VacancyMainModel>,
    onItemFavouriteToggled: (VacancyMainModel) -> Unit,
    onNavigateToVacancyScreen: () -> Unit
) {
    val defaultHorizontalPadding = PaddingValues(horizontal = 16.dp)

    val isFullState = remember {
        mutableStateOf(false)
    }

    LazyColumn(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            MainScreenSearchBar(
                onClick = if (isFullState.value) {
                    { isFullState.value = false }
                } else null, horizontalPadding = defaultHorizontalPadding
            )
        }
        item {
            if (!isFullState.value) RecommendationBlock(optionList) else VacancyTopRow(
                vacancyList.size
            )
        }
        item { MainTitle(text = stringResource(R.string.vacancies_for_you)) }
        items(if (!isFullState.value) vacancyList.take(3) else vacancyList) {
            VacancyCard(
                vacancy = it,
                onFavouriteClicked = { onItemFavouriteToggled.invoke(it) },
                onClick = { onNavigateToVacancyScreen.invoke() })
        }
        if (!isFullState.value) item {
            BigPrimaryButton(
                vacancyCount = vacancyList.size,
                onClick = { isFullState.value = true })
        }
    }
}

@Composable
fun MainTitle(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier.padding(horizontal = 16.dp),
        text = text,
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp
    )
}