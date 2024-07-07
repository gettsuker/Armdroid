package com.example.armdroid.screens.Connection.connectionScreenTablet

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.armdroid.ui.theme.ColorPrimary
import com.example.armdroid.ui.theme.Generic400


/**
 * Displays a connection screen specifically for Tablet devices.
 * The screen includes a "Connect" button that initiates a WebSocket connection.
 *
 * @param navController The Navigation Controller used to manage the screens of the application.
 *                      This allows the function to navigate to another screen when the connection is successful.
 * @param context The application context, passed as an input parameter from the activity in order to be able to use actions that may need the app context/permission.
 */
@Composable
fun ConnectionScreenTabletContent(navController: NavController, context: Context) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Generic400), contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clickable { /* Handle click event here */ }
                .background(color = Generic400)
                .border(
                    4.dp,
                    Color.Red,
                    shape = RoundedCornerShape(10.dp)
                ) // Add a red border with rounded corners

                .padding(vertical = 32.dp, horizontal = 64.dp)
        ) {
            Text(text = "Connect", color = Color.Red, fontSize = 64.sp) // Make the text red
        }
    }
}