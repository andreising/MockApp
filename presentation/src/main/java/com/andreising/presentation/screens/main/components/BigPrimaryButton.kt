package com.andreising.presentation.screens.main.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreising.presentation.theme.BlueSpecial

@Composable
fun BigPrimaryButton(
    vacancyCount: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    fun pluralizeVacancy(count: Int): String {
        val word = when {
            count % 10 == 1 && count % 100 != 11 -> "вакансия"
            count % 10 in 2..4 && count % 100 !in 12..14 -> "вакансии"
            else -> "вакансий"
        }
        return "Еще $count $word"
    }

    Button(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = BlueSpecial
        ),
        onClick = onClick,
        contentPadding = PaddingValues(vertical = 14.dp)
    ) {
        Text(
            text = pluralizeVacancy(vacancyCount),
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 21.sp
        )
    }
}