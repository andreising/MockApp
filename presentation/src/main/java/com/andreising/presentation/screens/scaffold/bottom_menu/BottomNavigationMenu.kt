package com.andreising.presentation.screens.scaffold.bottom_menu

import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import com.andreising.presentation.navigation.BottomNavigationItem

@Composable
fun BottomNavigationMenu(
    currentRoute: String?,
    favouritesCount: State<Int>,
    onNavigate: (String) -> Unit
) {

    val listItems = listOf(
        BottomNavigationItem.Search,
        BottomNavigationItem.Favourites(favouritesCount = favouritesCount.value),
        BottomNavigationItem.Responses,
        BottomNavigationItem.Messages,
        BottomNavigationItem.Profile
    )

    BottomAppBar(
        containerColor = Color.Transparent
    ) {
        listItems.forEach { item ->
            BottomBarItem(
                item = item,
                isSelected = currentRoute == item.route,
                count = if (item is BottomNavigationItem.Favourites) favouritesCount.value
                else null,
                onClick = { onNavigate.invoke(item.route) })

        }
    }
}