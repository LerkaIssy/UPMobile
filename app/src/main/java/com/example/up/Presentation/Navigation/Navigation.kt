package com.example.up.Presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.up.Presentation.Screens.Catalog.Catalog
import com.example.up.Presentation.Screens.MainPage.MainPage
import com.example.up.Presentation.Screens.SignIn.SignIn
import com.example.up.Presentation.Screens.SignUp.SignUp
import com.example.up.Presentation.Screens.SplashScreen.SplashScreen


/**
 *Реализация навигации в приложении
 * */

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
        composable("SignUp") {
            SignUp(navController)
        }
        composable("MainPage") {
            MainPage(navController)
        }
        composable("Catalog") {
            Catalog(navController)
        }
    }
}