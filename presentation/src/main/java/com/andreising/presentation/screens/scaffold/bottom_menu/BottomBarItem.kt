package com.andreising.presentation.screens.scaffold.bottom_menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreising.presentation.navigation.BottomNavigationItem
import com.andreising.presentation.theme.BlueSpecial
import com.andreising.presentation.theme.GrayBasic

@Composable
fun RowScope.BottomBarItem(
    item: BottomNavigationItem,
    isSelected: Boolean,
    iconSize: Dp = 24.dp,
    modifier: Modifier = Modifier,
    count: Int? = null,
    onClick: () -> Unit
) {
    NavigationBarItem(
        modifier = modifier,
        selected = isSelected,
        onClick = onClick,
        icon = {
            count?.let {
                Box(modifier = Modifier.size(iconSize), contentAlignment = Alignment.TopEnd) {
                    BottomBarItemIcon(item.iconId, modifier = Modifier.fillMaxSize())
                    BubbleItem(count = it)
                }
            } ?: BottomBarItemIcon(item.iconId, modifier = Modifier.size(iconSize))
        },
        label = {
            Text(text = stringResource(item.titleId), fontSize = 10.sp)
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = BlueSpecial,
            unselectedIconColor = GrayBasic,
            selectedTextColor = BlueSpecial,
            unselectedTextColor = GrayBasic,
            indicatorColor = Color.Transparent
        )
    )
}

@Composable
private fun BottomBarItemIcon(iconId: Int, modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(id = iconId),
        contentDescription = "bottom_item_icon",
        modifier = modifier
    )
}