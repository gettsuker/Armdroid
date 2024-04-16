package com.example.armdroid.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.armdroid.screens.Connection.ConnectionScreen
import com.example.armdroid.screens.Control.ControlScreen
import com.example.armdroid.screens.Splash.SplashScreen
import com.example.armdroid.viewmodels.SplashScreenViewModel

/**
 * function from the API "Navigation Compose" that allows any class that instantiate it to manage the navigation protocols of the application
 * All the screens of the application should have a composable instance here in the App navigation.
 */
@Composable
fun AppNavigation(
    context: Context
): NavController {


    val navController = rememberNavController()

    val splashScreenViewModel = viewModel<SplashScreenViewModel>()
    /**
     * Composable components of all the screens of the application
     */
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen(navController, context, splashScreenViewModel)
        }
        composable(route = AppScreens.ConnectionScreen.route) {
            ConnectionScreen(navController, context, splashScreenViewModel)
        }
        composable(route = AppScreens.ControlScreen.route) {
            ControlScreen(navController, context, splashScreenViewModel)
        }
    }


    return navController
}