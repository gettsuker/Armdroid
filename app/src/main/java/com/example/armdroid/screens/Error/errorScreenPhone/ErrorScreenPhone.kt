package com.example.armdroid.screens.Error.errorScreenPhone


import android.content.Context
import android.content.pm.ActivityInfo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.armdroid.MainActivity
import com.example.armdroid.ui.theme.ColorPrimary
import com.example.armdroid.ui.theme.Generic800
import com.example.armdroid.ui.theme.TextColor
import com.example.armdroid.R
import com.example.armdroid.screens.Error.retryScreenFromErrorScreen
import com.example.armdroid.ui.theme.Typography
import com.example.armdroid.utils.LocalToastController

/**
 * This Composable function is responsible for displaying an error screen specifically for phone devices.
 * The error screen includes an error icon, an error message, and a retry button.
 *
 * @param navController The Navigation Controller used to manage the screens of the application.
 * This allows the function to navigate to another screen when the retry button is clicked.
 * @param context The application context, passed as an input parameter from the activity in order to be able to use actions that may need the app context/permission.
 */
@Composable
fun ErrorMobilePhoneContent(
    navController: NavController,
    context: Context
) {
    val activity = context as MainActivity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
    val toastController = LocalToastController.current
    var showErrorToast = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Generic800),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(0.dp, 0.dp, 0.dp, 35.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                painterResource(id = R.drawable.ic_erroricon),
                contentDescription = stringResource(id = R.string.error_icon),
                tint = White, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
            )
            Text(
                text = stringResource(id = R.string.something_went_wrong_error_text),
                style = Typography.headlineLarge,
                color = TextColor,
                textAlign = TextAlign.Center, modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp)
            )

        }

        Button(
            colors = ButtonDefaults.outlinedButtonColors(ColorPrimary),
            onClick = {
                 retryScreenFromErrorScreen(navController, activity, showErrorToast, context)

            },
            modifier = Modifier
                .padding(0.dp, 35.dp, 0.dp, 0.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            Text(
                stringResource(id = R.string.retry),
                color = TextColor, modifier = Modifier.padding(6.dp, 8.dp)
            )

            if (showErrorToast.value) {
                val toastText = stringResource(id = R.string.Not_internet_connection)
                LaunchedEffect(Unit) {
                    toastController!!.showToast(
                        toastText,
                        Color.Red,
                        5000L
                    )
                    showErrorToast.value = false
                }
            }
        }

    }

}