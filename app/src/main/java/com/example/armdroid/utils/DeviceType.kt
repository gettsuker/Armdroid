package com.example.armdroid.utils


import android.content.Context
import android.content.res.Configuration
import android.util.DisplayMetrics
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

/**
 * Sealed class representing different device types.
 */
sealed class DeviceType {
    object Phone : DeviceType()
    object PhoneLandscape : DeviceType()
    object TabletPortrait : DeviceType()
    object TabletLandscape : DeviceType()


}

/**
 * Determines the device type based on the provided [Configuration].
 * This function is essential for adapting the user interface and behavior
 * based on the characteristics of the device's screen.
 *
 * @param configuration The [Configuration] containing information about the device screen.
 * @return The [DeviceType] representing the detected device type.
 */
fun getDeviceType(configuration: Configuration, typeofCall: Int = 0): DeviceType {


    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    return if (screenWidth <= Constants.MAX_SCREEN_WIDTH_VALUE_TO_BE_DETECTED_AS_A_MOBILE_PHONE) {
        DeviceType.Phone
    } else if (screenWidth in Constants.MAX_SCREEN_WIDTH_VALUE_TO_BE_DETECTED_AS_A_MOBILE_PHONE until screenHeight) {
        DeviceType.TabletPortrait
    } else {
        // Check if the device is a mobile phone in landscape.
        if (isPhoneInLandscape(configuration)) {
            when (typeofCall) {
                0 -> DeviceType.Phone
                else -> DeviceType.PhoneLandscape
            }

        } else {
            DeviceType.TabletLandscape
        }
    }
}

/**
 * Determines whether the device is in landscape mode and qualifies as a mobile phone.
 *
 * @param configuration The device's configuration, containing screen size information.
 * @return true if the device is a mobile phone in landscape mode, false otherwise.
 */
fun isPhoneInLandscape(configuration: Configuration): Boolean {
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    return screenWidth <= Constants.MAX_SCREEN_WIDTH_VALUE_TO_BE_DETECTED_AS_A_MOBILE_PHONE_IN_LANDSCAPE && screenHeight <= Constants.MAX_SCREEN_HEIGHT_VALUE_TO_BE_DETECTED_AS_A_MOBILE_PHONE_IN_LANDSCAPE
}

/**
 * Retrieves the screen width in density-independent pixels (DP) for the current device.
 *
 * @return The screen width in DP.
 */
@Composable
fun getDeviceScreenWidthDP(): Int {//Phone: 392 Tablet:768 TabletL: 1280

    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp

}

/**
 * Retrieves the screen height in density-independent pixels (DP) for the current device.
 *
 * @return The screen width in DP.
 */
@Composable
fun getDeviceScreenHeightDP(): Int {//Phone: 788 Tablet:1256 TabletL: 744

    val configuration = LocalConfiguration.current

    return configuration.screenHeightDp
}

/**
 * Calculates the adapted height in density-independent pixels (DP) based on the specified standard DP value.
 * This function considers the device type and adapts the height accordingly for different screen types.
 *
 * @param standardDP The standard DP value to be adapted.
 * @return The adapted height in DP.
 */
@Composable
fun getAdaptedDPHeight(standardDP: Int, typeofCall: Int = 0): Double {

    val configuration = LocalConfiguration.current
    when (getDeviceType(configuration, typeofCall)) {
        DeviceType.Phone -> {
            val conversionValue = standardDP.toDouble() / 788
            return (getDeviceScreenHeightDP() * conversionValue)
        }

        DeviceType.TabletPortrait -> {
            val conversionValue = standardDP.toDouble() / 1256
            return (getDeviceScreenHeightDP() * conversionValue)
        }

        DeviceType.TabletLandscape -> {
            val conversionValue = standardDP.toDouble() / 744
            return (getDeviceScreenHeightDP() * conversionValue)
        }

        DeviceType.PhoneLandscape -> {
            val conversionValue = standardDP.toDouble() / 370
            return (getDeviceScreenHeightDP() * conversionValue)
        }
    }
}

/**
 * Calculates the adapted width in density-independent pixels (DP) based on the specified standard DP value.
 * This function considers the device type and adapts the width accordingly for different screen types.
 *
 * @param standardDP The standard DP value to be adapted.
 * @return The adapted width in DP.
 */
@Composable
fun getAdaptedDPWidth(standardDP: Int, typeofCall: Int = 0): Double {

    val configuration = LocalConfiguration.current
    when (getDeviceType(configuration, typeofCall)) {
        DeviceType.Phone -> {
            val conversionValue = standardDP.toDouble() / 392
            return (getDeviceScreenWidthDP() * conversionValue)
        }

        DeviceType.TabletPortrait -> {
            val conversionValue = standardDP.toDouble() / 768
            return (getDeviceScreenWidthDP() * conversionValue)
        }

        DeviceType.TabletLandscape -> {
            val conversionValue = standardDP.toDouble() / 1280
            return (getDeviceScreenWidthDP() * conversionValue)
        }

        DeviceType.PhoneLandscape -> {
            val conversionValue = standardDP.toDouble() / 750
            return (getDeviceScreenWidthDP() * conversionValue)
        }
    }
}

/**
 * Calculates the screen size in inches based on the display metrics of the provided [context].
 *
 * @param context The context used to obtain display metrics.
 * @return The screen size in inches.
 */
fun getScreenSizeInches(context: Context): Double {
    val metrics: DisplayMetrics = context.resources.displayMetrics
    val widthInches = metrics.widthPixels / metrics.xdpi
    val heightInches = metrics.heightPixels / metrics.ydpi
    return kotlin.math.sqrt((widthInches * widthInches + heightInches * heightInches).toDouble())
}