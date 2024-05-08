package com.example.armdroid.screens.Splash.splashScreenTablet

import android.content.Context
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.armdroid.MainActivity
import com.example.armdroid.R
import com.example.armdroid.ui.theme.ColorSecondary

/**
 * This Composable function is responsible for displaying the splash screen specifically for tablet devices in portrait orientation.
 * The splash screen includes a logo image centered on a background.
 *
 * @param context The application context, passed as an input parameter from the activity in order to be able to use actions that may need the app context/permission.
 */
@Composable
fun SplashTablet() {

    val imageResource = R.drawable.splashlogo_mobile

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorSecondary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "SplashScreen"
        )
    }
}