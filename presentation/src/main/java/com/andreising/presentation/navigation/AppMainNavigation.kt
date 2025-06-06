package com.andreising.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppMainNavigation(
    navHostController: NavHostController,
    mainScreen: @Composable () -> Unit,
    favouriteScreen: @Composable () -> Unit
) {
    NavHost(navController = navHostController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            mainScreen.invoke()
        }

        composable(route = Screen.FavouriteScreen.route) {
            favouriteScreen.invoke()
        }
    }
}