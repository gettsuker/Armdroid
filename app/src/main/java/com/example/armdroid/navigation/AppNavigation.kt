package com.example.armdroid.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

/**
 * function from the API "Navigation Compose" that allows any class that instantiate it to manage the navigation protocols of the application
 * All the screens of the application should have a composable instance here in the App navigation.
 */
@Composable
fun AppNavigation(
    context: Context
): NavController {


    val appNavigationViewModel: AppNavigationViewModel = viewModel()

    val navController = rememberNavController()

    val splashScreenViewModel = viewModel<SplashScreenViewModel>()
    /**
     * Composable components of all the screens of the application
     */
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen(navController, context, splashScreenViewModel)
        }
        composable(route = AppScreens.ControlScreen.route) {
            ContentListScreen(navController, context, videoContentViewModel)
        }
    }
 /*   if (toastController?.show?.value == true) {
        CustomToastMessage(
            show = toastController._show,
            message = toastController.message.value,
            backgroundColor = toastController.backgroundColor.value,
            duration = 3000L, // duration in milliseconds
            onDismissRequest = { toastController._show.value = false }
        )
    }*/

    return navController
}