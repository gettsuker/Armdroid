package com.example.armdroid.screens.Splash

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.navigation.NavHostController
import com.example.armdroid.MainActivity
import com.example.armdroid.navigation.AppScreens
import com.example.armdroid.utils.DeviceType
import com.example.armdroid.utils.getDeviceType
import com.example.armdroid.viewmodels.SplashScreenViewModel
import java.util.concurrent.TimeUnit

@Composable
fun SplashScreen(
    navController: NavHostController,
    context: Context,
    splashScreenViewModel: SplashScreenViewModel
) {

    val activity = context as MainActivity

    val errorCodeCombined by combineLiveDataInts(
        splashScreenViewModel.errorCode,
        activity.errorCode!!
    ).observeAsState(
        initial = 0
    )


    navController.popBackStack()
    navController.navigate(AppScreens.ConnectionScreen.route)

    when (errorCodeCombined) {
        2 -> {
            activity.networkService._errorCode.value = 0
            activity.stopNetworkService()
            navController.navigate(
                AppScreens.ErrorScreen.route
            )
        }
    }
    val configuration = LocalConfiguration.current
    when (getDeviceType(configuration)) {
        DeviceType.Phone -> SplashPhone(context = context)
        else -> SplashTablet()
    }
    deleteOldCachedImages(context)
}

/**
 * This function is responsible for combining two LiveData objects of type Int into a single LiveData object.
 * The resulting LiveData object will emit a new value whenever either of the input LiveData objects emits a new value.
 *
 * @param liveData1 The first LiveData<Int> object to be combined.
 * @param liveData2 The second LiveData<Int> object to be combined.
 * @return A LiveData<Int> object that emits a new value whenever either liveData1 or liveData2 emits a new value.
 */
fun combineLiveDataInts(liveData1: LiveData<Int>, liveData2: LiveData<Int>): LiveData<Int> {
    val mediatorLiveData = MediatorLiveData<Int>()

    mediatorLiveData.addSource(liveData1) { newValue ->
        mediatorLiveData.value = newValue
    }

    mediatorLiveData.addSource(liveData2) { newValue ->
        mediatorLiveData.value = newValue
    }

    return mediatorLiveData
}

fun deleteOldCachedImages(context: Context) {
    val fiveDaysAgo = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(5)
    val allImagesAccessTimes = SharedPref.retrieveAllImagesAccessTimes()

    if (allImagesAccessTimes != null) {
        for ((imageHash, timeAny) in allImagesAccessTimes) {
            val time = timeAny as Long
            if (time < fiveDaysAgo) {
                context.imageLoader.diskCache?.remove(imageHash)
                SharedPref.removeAnImageAccessTime(imageHash)
            }
            Log.i("SplashScreen", "imageHash: $imageHash, Last Access Time: $time")
        }
    } else {
        Log.i("SplashScreen", "No image access times found.")
    }


}