package com.example.armdroid.utils

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
    fun isOnline(): Boolean {
        return try {
            val socket = Socket()
            val socketAddress = InetSocketAddress("8.8.8.8", 53) // Google DNS server and port 53
            socket.connect(socketAddress, 1500) // Timeout set to 1500 milliseconds (1.5 seconds)
            socket.close()

            true // If connection is successful within timeout, return true
        } catch (e: Exception) {
            // Exception occurred or connection failed, handle accordingly
            e.printStackTrace()

            false
        }
    }
}