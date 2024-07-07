package com.example.armdroid

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.armdroid.navigation.AppNavigation
import com.example.armdroid.ui.theme.ArmdroidTheme
import com.example.armdroid.ui.theme.Generic400
import com.example.armdroid.ui.theme.Generic700
import com.example.armdroid.utils.LocalToastController
import com.example.armdroid.utils.NetworkConnectionService
import com.example.armdroid.utils.ToastController
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MainActivity : ComponentActivity() {


    lateinit var networkService: NetworkConnectionService
    var navController: NavController? = null
    var errorCode: LiveData<Int>? = null
     lateinit var webSocket: WebSocket
     val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Properly initialize the networkService
        networkService =
            NetworkConnectionService(this, Dispatchers.Default)  // Default coroutine context

        networkService.start()
        errorCode = networkService.errorCode
        setContent {
            ArmdroidTheme {
                HideSystemBars()
                val coroutineScope = rememberCoroutineScope()
                val toastController = remember { ToastController(coroutineScope) }
                CompositionLocalProvider(LocalToastController provides toastController) {
                    ArmdroidTheme(darkTheme = true) {
                        navController = AppNavigation(this)
                    }
                }
            }
        }
    }

    fun stopNetworkService() {
        networkService.stop()
    }

    /**
     * This composable functions Hides the system bars to enhance the immersive experience of the application.
     * Once the User swipe in any of the place of the system bars(top or bottom of the screen).
     * The system bars shall appear again for a few seconds
     */
    @Composable
    fun HideSystemBars() {
        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView)
        // Configure the behavior of the hidden system bars.
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())
        window.statusBarColor = Generic700.toArgb()
    }

    @Composable
    fun ChangeStatusBarColor(colorPrimary: Color) {
        window.statusBarColor = colorPrimary.toArgb()
    }

    @Composable
    fun ToggleStatusBar(isStatusBarShown: Boolean) {
        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView)
        // Configure the behavior of the hidden system bars.
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        if (isStatusBarShown) {
            windowInsetsController.show(WindowInsetsCompat.Type.statusBars())

        } else {
            windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())
        }
    }
    suspend fun initiateWebSocket() : Boolean = suspendCoroutine { continuation ->
        var request = Request.Builder().url("ws://192.168.4.1/RobotArmInput").build()
        webSocket = client.newWebSocket(request, object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                super.onOpen(webSocket, response)
                println("WebSocket Opened")
                continuation.resume(true)
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)
                println("Received Message: $text")
            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                super.onMessage(webSocket, bytes)
                println("Received ByteString")
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosing(webSocket, code, reason)
                println("Closing: $code / $reason")
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                super.onFailure(webSocket, t, response)
                println("Error: ${t.message}")
                continuation.resume(false)
            }
        })

        client.dispatcher.executorService.shutdown()
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!, I am making changes",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArmdroidTheme {
        Greeting("Android")
    }
}

