package com.andreising.presentation.screens.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreising.presentation.R
import com.andreising.presentation.theme.GrayBasic
import com.andreising.presentation.theme.GraySecondary

@Composable
fun MainScreenSearchBar(horizontalPadding: PaddingValues, onClick: (() -> Unit)?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(horizontalPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SearchInputCard(modifier = Modifier.weight(1f), onClick = onClick)
        Spacer(modifier = Modifier.width(8.dp))
        FilterButtonCard(modifier = Modifier.size(40.dp))
    }
}

@Composable
fun SearchInputCard(modifier: Modifier = Modifier, onClick: (() -> Unit)?) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = GraySecondary),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchIcon(onClick)
            Spacer(modifier = Modifier.width(8.dp))
            SearchPlaceholderText()
        }
    }
}

@Composable
fun SearchIcon(onClick: (() -> Unit)?) {
    Icon(
        painter = painterResource(if (onClick != null) R.drawable.ic_back else R.drawable.ic_search),
        contentDescription = stringResource(if (onClick != null) R.string.back else R.string.search),
        tint = if (onClick != null) Color.White else GrayBasic,
        modifier = Modifier
            .clickable { onClick?.invoke() }
    )
}

@Composable
fun SearchPlaceholderText() {
    Text(
        text = "Должность, ключевые слова",
        color = GrayBasic,
        fontSize = 14.sp
    )
}

@Composable
fun FilterButtonCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = GraySecondary),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        FilterIcon()
    }
}

@Composable
fun FilterIcon() {
    Icon(
        painter = painterResource(R.drawable.ic_filter),
        contentDescription = stringResource(R.string.filter),
        tint = GrayBasic,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    )
}