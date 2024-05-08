package com.example.armdroid.screens.Error

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavController
import com.example.armdroid.MainActivity
import com.example.armdroid.screens.Error.errorScreenPhone.ErrorMobilePhoneContent
import com.example.armdroid.screens.Error.errorScreenTabletLandscape.ErrorTabletLandscapeContent
import com.example.armdroid.screens.Error.errorScreenTabletPortrait.ErrorTabletPortraitContent
import com.example.armdroid.utils.DeviceType
import com.example.armdroid.utils.NetworkManager.isOnline
import com.example.armdroid.utils.getDeviceType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

/**
 * Function called when the user clicks in the button "retry". this button will take the application to the screen that sent
 * the user to the error screen and will go through that screen code flow again in order to confirm that the error is solved now.
 */
fun retryScreenFromErrorScreen(
    navController: NavController,
    activity: MainActivity,
    showErrorToast: MutableState<Boolean>, context: Context
) {
    GlobalScope.launch(Dispatchers.IO) {
        val isOnline = isOnline(context)
        withContext(Dispatchers.Main) {
            if (isOnline) {
                activity.networkService.start()

                navController.popBackStack()

                showErrorToast.value = false
            } else {
                showErrorToast.value = true
            }
        }
    }
}