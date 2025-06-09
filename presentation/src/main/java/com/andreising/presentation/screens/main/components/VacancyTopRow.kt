package com.andreising.presentation.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreising.presentation.R
import com.andreising.presentation.theme.BlueSpecial

@Composable
fun VacancyTopRow(
    totalCount: Int,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CountText(count = totalCount)
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = stringResource(R.string.by_compliance),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = BlueSpecial,
                lineHeight = 17.sp
            )

            Icon(
                painter = painterResource(R.drawable.ic_sort_by),
                contentDescription = stringResource(R.string.sort_by),
                modifier = Modifier
                    .size(16.dp),
                tint = BlueSpecial
            )
        }
    }
}

@Composable
fun CountText(count: Int, modifier: Modifier = Modifier) {
    fun getVacancyWordForm(count: Int): String {
        val mod10 = count % 10
        val mod100 = count % 100
        return when {
            mod10 == 1 && mod100 != 11 -> "$count вакансия"
            mod10 in 2..4 && mod100 !in 12..14 -> "$count вакансии"
            else -> "$count вакансий"
        }
    }
    Text(
        modifier = modifier,
        text = getVacancyWordForm(count),
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = Color.White,
        lineHeight = 17.sp
    )
}