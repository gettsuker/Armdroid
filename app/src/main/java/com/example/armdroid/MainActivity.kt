package com.example.armdroid

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.armdroid.ui.theme.ArmdroidTheme
import com.example.armdroid.utils.NetworkConnectionService

class MainActivity : ComponentActivity() {


    lateinit var networkService: NetworkConnectionService
    var navController: NavController? = null
    var errorCode: LiveData<Int>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArmdroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
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
        window.statusBarColor = Color.WHITE
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

