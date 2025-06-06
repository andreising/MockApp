package com.andreising.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.andreising.presentation.screens.favourite.FavouriteScreen
import com.andreising.presentation.screens.main.MainScreen
import com.andreising.presentation.screens.messages.MessageScreen
import com.andreising.presentation.screens.profile.ProfileScreen
import com.andreising.presentation.screens.responses.ResponseScreen
import com.andreising.presentation.screens.scaffold.ScaffoldScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScaffoldScreen(
                mainScreen = { MainScreen() },
                favouriteScreen = { FavouriteScreen() },
                responseScreen = { ResponseScreen() },
                messagesScreen = { MessageScreen() },
                profileScreen = { ProfileScreen() }
            )
        }
    }
}