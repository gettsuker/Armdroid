package com.example.armdroid.screens.Control

import ControlScreenPhoneContent
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController
import com.example.armdroid.screens.Control.controlScreenTablet.ControlScreenTabletContent
import com.example.armdroid.utils.DeviceType
import com.example.armdroid.utils.getDeviceType
import com.example.armdroid.viewmodels.SplashScreenViewModel

@Composable
fun ControlScreen(
    navController: NavHostController,
    context: Context,
    splashScreenViewModel: SplashScreenViewModel
) {
    val configuration = LocalConfiguration.current
    when (getDeviceType(configuration)) {
        DeviceType.Phone -> ControlScreenPhoneContent(navController = navController, context)

        else -> {

            ControlScreenTabletContent(navController = navController, context)

        }
    }
}