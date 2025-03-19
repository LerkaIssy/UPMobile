package com.example.up.Presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.up.Presentation.Screens.SignIn.SignIn
import com.example.up.Presentation.Screens.SplashScreen.SplashScreen


@Composable
fun Navigation()
{
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "SplashScreen"
    )
    {
        composable("SplashScreen") {
            SplashScreen(navController)
        }
        composable("SignIn") {
            SignIn(navController)
        }
    }
}