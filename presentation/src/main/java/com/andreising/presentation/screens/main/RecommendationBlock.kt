package com.andreising.presentation.screens.main

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreising.domain.model.OptionMainModel
import com.andreising.domain.model.Recommendation
import com.andreising.presentation.R
import com.andreising.presentation.theme.DarkGraySecondary
import com.andreising.presentation.theme.Primary
import androidx.core.net.toUri

@Composable
fun RecommendationBlock(recommendationList: List<OptionMainModel>) {
    if (recommendationList.isEmpty()) return

    LazyRow(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item { Spacer(Modifier.width(8.dp)) }
        items(recommendationList) {
            FastFilterCard(it)
        }
        item { Spacer(Modifier.width(8.dp)) }
    }

}

@Composable
fun FastFilterCard(
    model: OptionMainModel,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Card(
        modifier = modifier
            .size(width = 132.dp, height = 120.dp)
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, model.link.toUri())
                context.startActivity(intent)
            },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = DarkGraySecondary)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        ) {
            val maxLines = if (model.buttonText == null) 3 else 2

            model.recommendation.let {
                if (it != Recommendation.UNDEFINED) {
                    Image(
                        painter = painterResource(
                            id = getRecommendationIcon(it) ?: error("Undefined")
                        ),
                        contentDescription = "Recommendation Icon",
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .size(32.dp)
                    )
                }
            }

            Text(
                text = model.title,
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 17.sp,
                maxLines = maxLines,
                overflow = TextOverflow.Visible
            )

            model.buttonText?.let {
                Text(
                    text = it,
                    color = Primary,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 17.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

private fun getRecommendationIcon(recommendation: Recommendation): Int? {
    return when (recommendation) {
        Recommendation.NEAR_VACANCIES -> R.drawable.ic_near_vacancies
        Recommendation.LEVEL_UP_RESUME -> R.drawable.ic_lvl_up_resume
        Recommendation.TEMPORARY_JOB -> R.drawable.ic_temporary_job
        else -> null
    }
}