package com.andreising.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppMainNavigation(
    navHostController: NavHostController,
    scaffoldScreen: @Composable () -> Unit,
    vacancyScreen: @Composable () -> Unit
) {
    NavHost(navController = navHostController, startDestination = Screen.ScaffoldScreen.route) {
        composable(route = Screen.ScaffoldScreen.route) {
            scaffoldScreen.invoke()
        }

        composable(route = Screen.VacancyScreen.route) {
            vacancyScreen.invoke()
        }
    }
}