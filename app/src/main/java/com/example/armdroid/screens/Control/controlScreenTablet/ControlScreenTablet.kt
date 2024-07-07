package com.example.armdroid.screens.Control.controlScreenTablet


import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@Composable
fun ControlScreenTabletContent(navController: NavController, context: Context) {
    var sliderValue1 by remember { mutableStateOf(90f) }
    var sliderValue2 by remember { mutableStateOf(90f) }
    var sliderValue3 by remember { mutableStateOf(90f) }
    var sliderValue4 by remember { mutableStateOf(90f) }
    var playButtonValue by remember {
        mutableStateOf(false)
    }
    var recordButtonValue by remember {
        mutableStateOf(false)
    }
    Scaffold(topBar = { TopBar(navController, 1, 0) }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = Generic700)
        ) {

            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Gripper", color = Color.White, fontSize = 32.sp)
                Slider(
                    value = sliderValue1,
                    onValueChange = {
                        sliderValue1 = it
                        sendWebSocketMessage("Gripper,${it.toInt()}", context = context)
                    },
                    valueRange = 0f..180f, colors = SliderDefaults.colors(
                        thumbColor = ColorPrimary,
                        activeTrackColor = ColorPrimary,
                        inactiveTrackColor = ColorPrimary.copy(0.5f)
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Wrist", color = Color.White, fontSize = 32.sp)
                Slider(
                    value = sliderValue4,
                    onValueChange = {
                        sliderValue4 = it
                        sendWebSocketMessage("Wrist,${it.toInt()}", context = context)
                    },
                    valueRange = 0f..180f, colors = SliderDefaults.colors(
                        thumbColor = ColorPrimary,
                        activeTrackColor = ColorPrimary,
                        inactiveTrackColor = ColorPrimary.copy(0.5f)
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Elbow", color = Color.White, fontSize = 32.sp)
                Slider(
                    value = sliderValue2,
                    onValueChange = {
                        sliderValue2 = it
                        sendWebSocketMessage("Elbow,${it.toInt()}", context = context)
                    },
                    valueRange = 0f..180f, colors = SliderDefaults.colors(
                        thumbColor = ColorPrimary,
                        activeTrackColor = ColorPrimary,
                        inactiveTrackColor = ColorPrimary.copy(0.5f)
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Shoulder", color = Color.White, fontSize = 32.sp)
                Slider(
                    value = sliderValue3,
                    onValueChange = {
                        sliderValue3 = it
                        sendWebSocketMessage("Shoulder,${it.toInt()}", context = context)
                    },
                    valueRange = 0f..180f, colors = SliderDefaults.colors(
                        thumbColor = ColorPrimary,
                        activeTrackColor = ColorPrimary,
                        inactiveTrackColor = ColorPrimary.copy(0.5f)
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Base", color = Color.White, fontSize = 32.sp)
                Slider(
                    value = sliderValue4,
                    onValueChange = {
                        sliderValue4 = it
                        sendWebSocketMessage("Base,${it.toInt()}", context = context)
                    },
                    valueRange = 0f..180f, colors = SliderDefaults.colors(
                        thumbColor = ColorPrimary,
                        activeTrackColor = ColorPrimary,
                        inactiveTrackColor = ColorPrimary.copy(0.5f)
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                Column() {
                    if (!playButtonValue) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    playButtonValue = !playButtonValue
                                    recordButtonValue = false
                                    sendWebSocketMessage("Record,0", context = context)
                                    sendWebSocketMessage("Play,1", context = context)
                                }
                                .background(color = Generic700)
                                .border(
                                    2.dp,
                                    Color.White,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(vertical = 8.dp, horizontal = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Play", color = Color.White, fontSize = 24.sp)
                        }


                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    playButtonValue = !playButtonValue
                                    sendWebSocketMessage("Play,0", context = context)
                                }
                                .background(color = Generic700)
                                .border(
                                    2.dp,
                                    Color.Green,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(vertical = 8.dp, horizontal = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Playing", color = Color.Green, fontSize = 24.sp)
                        }

                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    if (!recordButtonValue) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    recordButtonValue = !recordButtonValue
                                    playButtonValue = false
                                    sendWebSocketMessage("Play,0", context = context)
                                    sendWebSocketMessage("Record,1", context = context)
                                }
                                .background(color = Generic700)
                                .border(
                                    2.dp,
                                    Color.White,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(vertical = 8.dp, horizontal = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Record", color = Color.White, fontSize = 24.sp)
                        }

                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    recordButtonValue = !recordButtonValue
                                    sendWebSocketMessage("Record,0", context = context)
                                }
                                .background(color = Generic700)
                                .border(
                                    2.dp,
                                    Color.Yellow,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(vertical = 8.dp, horizontal = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Recording", color = Color.Yellow, fontSize = 24.sp)
                        }

                    }

                }
            }
        }
    }

}

private fun sendWebSocketMessage(message: String, context: Context) {
    val activity = context as MainActivity
    val webSocket = activity.webSocket
    webSocket.send(message)
}