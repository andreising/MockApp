package com.andreising.presentation.navigation

sealed class Screen(val route: String) {
    data object MainScreen: Screen(route = MAIN_SCREEN_ROUTE)
    data object FavouriteScreen: Screen(route = FAVOURITE_SCREEN_ROUTE)
    data object ResponsesScreen : Screen(route = RESPONSES_SCREEN)
    data object MessagesScreen : Screen(route = MESSAGES_SCREEN)
    data object ProfileScreen : Screen(route = PROFILE_SCREEN)
    data object VacancyScreen : Screen(route = VACANCY_SCREEN)
    data object ScaffoldScreen : Screen(route = SCAFFOLD_SCREEN)

    companion object {
        private const val MAIN_SCREEN_ROUTE = "main_screen"
        private const val FAVOURITE_SCREEN_ROUTE = "favourite_screen"
        private const val RESPONSES_SCREEN = "responses_screen"
        private const val MESSAGES_SCREEN = "messages_screen"
        private const val PROFILE_SCREEN = "profile_screen"
        private const val VACANCY_SCREEN = "vacancy_screen"
        private const val SCAFFOLD_SCREEN = "scaffold_screen"
    }
}