package com.example.armdroid.utils

import android.app.ActivityManager
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.PowerManager
import java.net.InetSocketAddress
import java.net.Socket

/**
 * A utility object for checking the device's internet connectivity status.
 */
object NetworkManager {
    /**
     * Checks if the device has access to the internet through a ping to google DNS services port 53.
     *
     * @param context The application context.
     * @return true if the device has internet connectivity, false otherwise.
     */
    fun isOnline(context: Context): Boolean {
        val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        val isScreenOn = powerManager.isInteractive
        val isAppInForeground = isAppInForeground(context)

        return if (isScreenOn && isAppInForeground) {
            try {
                val socket = Socket()
                val socketAddress =
                    InetSocketAddress("8.8.8.8", 53) // Google DNS server and port 53
                socket.connect(
                    socketAddress,
                    1500
                ) // Timeout set to 1500 milliseconds (1.5 seconds)
                socket.close()
                // FirebaseCrashlytics.getInstance().log("Internet State : " + true)
                true // If connection is successful within timeout, return true
            } catch (e: Exception) {
                // Exception occurred or connection failed, handle accordingly
                e.printStackTrace()
                // FirebaseCrashlytics.getInstance().log("Internet State : " + false)
                false
            }
        } else {
            // If the screen is off, assume internet connectivity by default
            true
        }
    }
}

fun isAppInForeground(context: Context): Boolean {
    val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val runningAppProcesses = activityManager.runningAppProcesses
    if (runningAppProcesses != null) {
        for (appProcess in runningAppProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName == context.packageName) {
                return true
            }
        }
    }
    return false
}