package com.example.armdroid.screens.Connection

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.armdroid.R
import com.example.armdroid.screens.Connection.connectionScreenPhone.ConnectionScreenPhoneContent
import com.example.armdroid.screens.Connection.connectionScreenTablet.ConnectionScreenTabletContent
import com.example.armdroid.screens.Error.errorScreenPhone.ErrorMobilePhoneContent
import com.example.armdroid.screens.Error.errorScreenTabletLandscape.ErrorTabletLandscapeContent
import com.example.armdroid.screens.Error.errorScreenTabletPortrait.ErrorTabletPortraitContent
import com.example.armdroid.ui.theme.Generic700
import com.example.armdroid.ui.theme.White
import com.example.armdroid.utils.DeviceType
import com.example.armdroid.utils.getDeviceType
import com.example.armdroid.viewmodels.SplashScreenViewModel


/**
 * Determines the appropriate screen content based on the device type (phone or tablet).
 *
 * @param navController The Navigation Controller used to manage the screens of the application.
 *                      This allows the function to navigate to another screen based on the device type.
 * @param context The application context, passed as an input parameter from the activity in order to be able to use actions that may need the app context/permission.
 * @param splashScreenViewModel The ViewModel associated with the splash screen.
 */
@Composable
fun ConnectionScreen(
    navController: NavHostController,
    context: Context,
    splashScreenViewModel: SplashScreenViewModel
) {
    val configuration = LocalConfiguration.current
    when (getDeviceType(configuration)) {
        DeviceType.Phone -> ConnectionScreenPhoneContent(
            navController = navController,
            context = context
        )

        else -> {

            ConnectionScreenTabletContent(
                navController = navController,
                context = context
            )
        }
    }
}

/**
 * Displays a top app bar with a company logo.
 *
 * @param navController The Navigation Controller used to manage the screens of the application.
 *                      This allows the function to navigate to another screen when needed.
 * @param elevation The elevation (shadow) of the app bar.
 * @param deviceType An integer representing the type of device (e.g., phone or tablet).
 */
@Composable
fun TopBar(navController: NavController, elevation: Int, deviceType: Int) {

    TopAppBar(
        contentColor = White, backgroundColor = Generic700, elevation = elevation.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.upmlogotipo),
                contentDescription = "Small company Logo",
                modifier = Modifier.padding(start = 19.dp)
            )


        }
    }
}