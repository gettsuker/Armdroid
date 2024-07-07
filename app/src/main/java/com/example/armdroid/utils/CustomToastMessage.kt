package com.example.armdroid.utils


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.armdroid.ui.theme.White
import kotlinx.coroutines.delay
import com.example.armdroid.MainActivity
import com.example.armdroid.R
/**
 * This Composable function is responsible for displaying a custom toast message.
 * It receives a [MutableState] [show] that controls the visibility of the toast, a [String] [message] that represents the text to be displayed on the toast, a [Color] [backgroundColor] that sets the background color of the toast, a [Long] [duration] that sets the duration of the toast in milliseconds, and a function [onDismissRequest] that is called when the toast is dismissed.
 *
 * The function gets the current configuration and the device type. Depending on the device type, it calls the PhoneToastMessage, TabletPortraitToastMessage, or TabletLandscapeToastMessage function to display the toast.
 *
 * @param show A [MutableState] that controls the visibility of the toast.
 * @param message A [String] that represents the text to be displayed on the toast.
 * @param backgroundColor A [Color] that sets the background color of the toast.
 * @param duration A [Long] that sets the duration of the toast in milliseconds.
 * @param onDismissRequest A function that is called when the toast is dismissed.
 */
@Composable
fun CustomToastMessage(
    show: MutableState<Boolean>,
    message: String,
    backgroundColor: Color,
    duration: Long, // duration in milliseconds
    onDismissRequest: () -> Unit
) {
    val configuration = LocalConfiguration.current
    when (getDeviceType(configuration)) {
        DeviceType.Phone -> PhoneToastMessage(
            show,
            message,
            backgroundColor,
            duration,
            onDismissRequest
        )
        DeviceType.TabletPortrait -> TabletPortraitToastMessage(
            show,
            message,
            backgroundColor,
            duration,
            onDismissRequest
        )
        DeviceType.TabletLandscape
        -> TabletLandscapeToastMessage(show, message, backgroundColor, duration, onDismissRequest)
        else -> {}
    }
}


/**
 * A private Composable function, PhoneToastMessage, responsible for displaying a toast message on phone devices.
 * This toast is a visual cue to the user, providing feedback or information that is non-intrusive and automatically dismisses after a specified duration.
 * The function encapsulates the necessary UI elements and behavior for creating and presenting a toast on phone screens.
 *
 * @param show A [MutableState] boolean representing the visibility of the toast. When true, the toast is displayed.
 * @param message The text message to be displayed in the toast.
 * @param backgroundColor The background color of the toast, enhancing visual distinction.
 * @param duration The duration in milliseconds for which the toast remains visible before automatically dismissing.
 * @param onDismissRequest A lambda function to be executed when the user dismisses the toast, typically triggered by tapping a close button.
 */
@Composable
private fun PhoneToastMessage(
    show: MutableState<Boolean>,
    message: String,
    backgroundColor: Color,
    duration: Long, // duration in milliseconds
    onDismissRequest: () -> Unit
) {
    if (show.value) {
        // Automatically dismiss the toast after the specified duration
        LaunchedEffect(key1 = show.value) {
            delay(duration)
            show.value = false
        }
        // UI elements for the toast

        Box(
            modifier = Modifier
                .fillMaxSize() // fill the entire screen
                .padding(start = 16.dp, end = 16.dp, bottom = 96.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Card(
                backgroundColor = backgroundColor,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(
                        text = message,
                        color = White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp, 8.dp, 0.dp, 8.dp)
                    )
                    // Close button to dismiss the toast

                    IconButton(onClick = onDismissRequest) {
                        Icon(
                            painterResource(id = R.drawable.ic_xicon),
                            contentDescription = "close Toast Icon",
                            tint = White
                        )
                    }
                }
            }
        }
    }
}


/**
 * A private Composable function, TabletPortraitToastMessage, responsible for displaying a toast message on tablet devices in portrait orientation.
 * This toast is a visual cue to the user, providing feedback or information that is non-intrusive and automatically dismisses after a specified duration.
 * The function encapsulates the necessary UI elements and behavior for creating and presenting a toast on phone screens.
 *
 * @param show A [MutableState] boolean representing the visibility of the toast. When true, the toast is displayed.
 * @param message The text message to be displayed in the toast.
 * @param backgroundColor The background color of the toast, enhancing visual distinction.
 * @param duration The duration in milliseconds for which the toast remains visible before automatically dismissing.
 * @param onDismissRequest A lambda function to be executed when the user dismisses the toast, typically triggered by tapping a close button.
 */
@Composable
private fun TabletPortraitToastMessage(
    show: MutableState<Boolean>,
    message: String,
    backgroundColor: Color,
    duration: Long, // duration in milliseconds
    onDismissRequest: () -> Unit
) {
    if (show.value) {
        // Automatically dismiss the toast after the specified duration
        LaunchedEffect(key1 = show.value) {
            delay(duration)
            show.value = false
        }

        Box(
            modifier = Modifier
                .fillMaxSize() // fill the entire screen
                .padding(start = 32.dp, end = 32.dp, bottom = 96.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Card(
                backgroundColor = backgroundColor,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(
                        text = message,
                        color = White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp, 8.dp, 0.dp, 8.dp)
                    )
                    IconButton(onClick = onDismissRequest) {
                        Icon(
                            painterResource(id = R.drawable.ic_xicon),
                            contentDescription = "close Toast Icon",
                            tint = White
                        )
                    }
                }
            }
        }
    }
}


/**
 * A private Composable function, TabletLandscapeToastMessage, responsible for displaying a toast message on tablet devices in landscape orientation.
 * This toast is a visual cue to the user, providing feedback or information that is non-intrusive and automatically dismisses after a specified duration.
 * The function encapsulates the necessary UI elements and behavior for creating and presenting a toast on phone screens.
 *
 * @param show A [MutableState] boolean representing the visibility of the toast. When true, the toast is displayed.
 * @param message The text message to be displayed in the toast.
 * @param backgroundColor The background color of the toast, enhancing visual distinction.
 * @param duration The duration in milliseconds for which the toast remains visible before automatically dismissing.
 * @param onDismissRequest A lambda function to be executed when the user dismisses the toast, typically triggered by tapping a close button.
 */
@Composable
private fun TabletLandscapeToastMessage(
    show: MutableState<Boolean>,
    message: String,
    backgroundColor: Color,
    duration: Long, // duration in milliseconds
    onDismissRequest: () -> Unit
) {
    if (show.value) {
        // Automatically dismiss the toast after the specified duration
        LaunchedEffect(key1 = show.value) {
            delay(duration)
            show.value = false
        }

        Box(
            modifier = Modifier
                .fillMaxSize() // fill the entire screen
                .padding(start = 270.dp, end = 270.dp, bottom = 48.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Card(
                backgroundColor = backgroundColor,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(
                        text = message,
                        color = White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp, 8.dp, 0.dp, 8.dp)
                    )
                    IconButton(onClick = onDismissRequest) {
                        Icon(
                            painterResource(id = R.drawable.ic_xicon),
                            contentDescription = "close Toast Icon",
                            tint = White
                        )
                    }
                }
            }
        }
    }
}