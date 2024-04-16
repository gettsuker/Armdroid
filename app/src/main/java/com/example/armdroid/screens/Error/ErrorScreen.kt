package com.example.armdroid.screens.Error

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavController
import com.example.armdroid.screens.Error.errorScreenTabletPortrait.ErrorMobilePhoneContent
import com.example.armdroid.utils.DeviceType
import com.example.armdroid.utils.getDeviceType

/**
 * Composable screen that represents the errorScreen. this screen will be displayed to the user if an error is triggered
 * in the application or when the application is not behaving as intended.
 * @param navController Navigation controller of the APPNavigation class
 * @param context Application context that came from the MainActivity
 */
@Composable
fun ErrorScreen(navController: NavController, context: Context) {
    val configuration = LocalConfiguration.current
    when (getDeviceType(configuration)) {
        DeviceType.Phone -> ErrorMobilePhoneContent(
            navController = navController,
            context = context
        )
        DeviceType.TabletPortrait -> ErrorTabletPortraitContent(
            navController = navController,
            context = context
        )
        DeviceType.TabletLandscape -> ErrorTabletLandscapeContent(
            navController = navController,
            context = context
        )
        else -> {}
    }
}