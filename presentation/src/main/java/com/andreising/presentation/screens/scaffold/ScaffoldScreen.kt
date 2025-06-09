package com.andreising.presentation.screens.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.andreising.presentation.navigation.AppScaffoldNavigation
import com.andreising.presentation.screens.scaffold.bottom_menu.BottomNavigationMenu
import com.andreising.presentation.theme.MainBlack

@Composable
fun ScaffoldScreen(
    mainScreen: @Composable () -> Unit,
    favouriteScreen: @Composable () -> Unit,
    responseScreen: @Composable () -> Unit,
    messagesScreen: @Composable () -> Unit,
    profileScreen: @Composable () -> Unit
) {
    val navHostController = rememberNavController()
    val viewModel: ScaffoldScreenViewModel = hiltViewModel()
    val vacancyListSize = viewModel.vacancyListSize.collectAsState(0)

    val currentBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            BottomNavigationMenu(
                currentRoute = currentRoute,
                favouritesCount = vacancyListSize,
                onNavigate = { route ->
                    navHostController.navigate(route)
                }
            )
        }, containerColor = MainBlack
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            AppScaffoldNavigation(
                navHostController = navHostController,
                mainScreen = mainScreen,
                favouriteScreen = favouriteScreen,
                responseScreen = responseScreen,
                messagesScreen = messagesScreen,
                profileScreen = profileScreen
            )
        }
    }
}