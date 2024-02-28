package com.example.armdroid.navigation

/**
 * Sealed class that has an object (constant) of every composable screen in the app
 */
sealed class AppScreens(val route: String){
    object ConnectionScreen : AppScreens("Connection_Screen")
    object ControlScreen : AppScreens("Control_Screen")
    object SplashScreen : AppScreens("Splash_Screen")

}