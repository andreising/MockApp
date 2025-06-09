package com.andreising.presentation.screens.favourite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.andreising.presentation.R
import com.andreising.presentation.screens.main.MainTitle
import com.andreising.presentation.screens.main.components.CountText
import com.andreising.presentation.screens.main.components.VacancyCard

@Composable
fun FavouriteScreen() {
    val viewModel: FavouriteScreenViewModel = hiltViewModel()
    val vacancyList by viewModel.vacancyList.collectAsState()

    LazyColumn(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { MainTitle(text = stringResource(R.string.favourites)) }
        if (vacancyList.isEmpty()) {
            item {
                Text(
                    text = "Список избранных пуст",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 24.dp, start = 16.dp)
                )
            }
        } else {
            item { CountText(count = vacancyList.size, modifier = Modifier.padding(16.dp)) }
            items(vacancyList) { vacancy ->
                VacancyCard(
                    vacancy = vacancy,
                    onFavouriteClicked = { viewModel.onItemToggled(vacancy) },
                    onClick = { /* Навигация к деталям */ }
                )
            }
        }
    }
}