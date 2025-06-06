package com.andreising.presentation.navigation

sealed class Screen(val route: String) {
    data object MainScreen: Screen(route = MAIN_SCREEN_ROUTE)
    data object FavouriteScreen: Screen(route = FAVOURITE_SCREEN_ROUTE)

    companion object {
        private const val MAIN_SCREEN_ROUTE = "main_screen"
        private const val FAVOURITE_SCREEN_ROUTE = "favourite_screen"
    }
}