package com.andreising.presentation.screens.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreising.domain.model.VacancyMainModel
import com.andreising.presentation.R
import com.andreising.presentation.theme.BlueSpecial
import com.andreising.presentation.theme.DarkGraySecondary
import com.andreising.presentation.theme.GrayBasic
import com.andreising.presentation.theme.Primary
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun VacancyCard(vacancy: VacancyMainModel, onFavouriteClicked: () -> Unit, onClick: () -> Unit) {

    fun getPeopleText(count: Int): String {
        val peopleWord = when {
            count % 100 in 11..14 -> "человек"
            count % 10 == 1 -> "человек"
            count % 10 in 2..4 -> "человека"
            else -> "человек"
        }
        return "Сейчас просматривает $count $peopleWord"
    }

    fun formatDate(dateString: String): String {
        return try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val outputFormat = SimpleDateFormat("d MMMM", Locale("ru"))
            val date = inputFormat.parse(dateString)
            if (date != null) {
                outputFormat.format(date)
            } else {
                dateString
            }
        } catch (e: Exception) {
            dateString
        }
    }

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = DarkGraySecondary),
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.Start
            ) {
                vacancy.lookingNumber.let {
                    if (it != 0) Text(
                        text = getPeopleText(it),
                        color = Primary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 17.sp
                    )
                }

                Text(
                    text = vacancy.title,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 19.sp
                )
                Column {
                    Text(
                        text = vacancy.town,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 17.sp
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = vacancy.company,
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            lineHeight = 17.sp
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            painter = painterResource(R.drawable.ic_checked_company),
                            modifier = Modifier
                                .size(16.dp),
                            contentDescription = vacancy.company.toString()
                                    + stringResource(R.string.checked_company),
                            tint = GrayBasic
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.ic_experience),
                        modifier = Modifier
                            .size(12.dp),
                        contentDescription = vacancy.title + stringResource(R.string.experince),
                        tint = Color.White
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = vacancy.experienceText,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

                Text(
                    text = "Опубликовано " + formatDate(dateString = vacancy.publishedDate),
                    color = GrayBasic,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 17.sp
                )
                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Primary
                    )
                ) {
                    Text(
                        text = stringResource(R.string.respond),
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 18.2.sp
                    )
                }
            }

            Icon(
                painter = painterResource(
                    if (vacancy.isFavourite) R.drawable.ic_favourite_true
                    else R.drawable.ic_favourites_false
                ),
                modifier = Modifier
                    .padding(top = 16.dp, end = 16.dp)
                    .size(24.dp)
                    .align(Alignment.TopEnd)
                    .clickable(onClick = { onFavouriteClicked.invoke() }),
                contentDescription = vacancy.title + stringResource(R.string.favourite),
                tint = if (vacancy.isFavourite) BlueSpecial
                else GrayBasic
            )
        }
    }
}
