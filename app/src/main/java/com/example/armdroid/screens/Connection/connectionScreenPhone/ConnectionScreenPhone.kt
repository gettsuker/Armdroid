package com.example.armdroid.screens.Connection.connectionScreenPhone

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.armdroid.MainActivity
import com.example.armdroid.navigation.AppScreens
import com.example.armdroid.screens.Connection.TopBar
import com.example.armdroid.ui.theme.ColorPrimary
import com.example.armdroid.ui.theme.Generic400
import com.example.armdroid.ui.theme.Generic700
import com.example.armdroid.utils.LocalToastController
import com.example.armdroid.utils.ToastController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.sign


/**
 * Displays a connection screen specifically for phone devices.
 * The screen includes a "Connect" button that initiates a WebSocket connection.
 *
 * @param navController The Navigation Controller used to manage the screens of the application.
 *                      This allows the function to navigate to another screen when the connection is successful.
 * @param context The application context, passed as an input parameter from the activity in order to be able to use actions that may need the app context/permission.
 */
@Composable
fun ConnectionScreenPhoneContent(navController: NavController, context: Context) {
    val activity = context as MainActivity

    val toastController = LocalToastController.current
    Scaffold(topBar = { TopBar(navController, 1, 0) }) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(color = Generic700), contentAlignment = Alignment.Center
        ) {
            val scope = rememberCoroutineScope()
            Box(
                modifier = Modifier
                    .clickable {
                         scope.launch {
                              val isSuccessfulRequest = activity.initiateWebSocket()
                              if (isSuccessfulRequest) {
                                  navController.navigate(AppScreens.ControlScreen.route)
                                  toastController!!.showToast(
                                      "Connected",
                                      Color.Green,
                                      5000
                                  )
                              } else {
                                  toastController!!.showToast(
                                      "Can not connect to Board, please make sure that the device is connected to the Wifi RobotArm",
                                      Color.Red,
                                      5000
                                  )
                              }
                          }
                    }
                    .background(color = Generic700)
                    .border(
                        4.dp,
                        Color.White,
                        shape = RoundedCornerShape(10.dp)
                    ) // Add a red border with rounded corners

                    .padding(vertical = 16.dp, horizontal = 32.dp)
            ) {
                Text(text = "Connect", color = Color.White, fontSize = 32.sp) // Make the text red
            }

        }

    }

}