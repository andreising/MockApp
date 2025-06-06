package com.andreising.presentation.navigation

import com.andreising.presentation.R

sealed class BottomNavigationItem(val titleId: Int, val iconId: Int, val route: String) {
    data object Search :
        BottomNavigationItem(R.string.search, R.drawable.ic_search, Screen.MainScreen.route)

    data class Favourites(val favouritesCount: Int) :
        BottomNavigationItem(
            R.string.favourites,
            R.drawable.ic_favourites,
            Screen.FavouriteScreen.route
        )

    data object Responses : BottomNavigationItem(
        R.string.responses, R.drawable.ic_responses,
        Screen.ResponsesScreen.route
    )

    data object Messages :
        BottomNavigationItem(R.string.messages, R.drawable.ic_messages, Screen.MessagesScreen.route)

    data object Profile :
        BottomNavigationItem(R.string.profile, R.drawable.ic_profile, Screen.ProfileScreen.route)

}