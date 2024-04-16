package com.example.armdroid.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import com.example.armdroid.ui.theme.ColorAccent
import com.example.armdroid.ui.theme.ColorAccentDark
import com.example.armdroid.ui.theme.ColorAccentLight
import com.example.armdroid.ui.theme.ColorPrimary
import com.example.armdroid.ui.theme.ColorPrimaryDark
import com.example.armdroid.ui.theme.ColorPrimaryLight
import com.example.armdroid.ui.theme.ColorPrimaryPastel
import com.example.armdroid.ui.theme.ColorSecondary
import com.example.armdroid.ui.theme.ColorSecondaryDark
import com.example.armdroid.ui.theme.ColorSecondaryLight
import com.example.armdroid.ui.theme.DefaultColor
import com.example.armdroid.ui.theme.Generic400
import com.example.armdroid.ui.theme.Generic600
import com.example.armdroid.ui.theme.Generic700
import com.example.armdroid.ui.theme.Generic800
import com.example.armdroid.ui.theme.GenericAndroidWhiteLabelGenericBlack
import com.example.armdroid.ui.theme.GenericDivider
import com.example.armdroid.ui.theme.IconColor
import com.example.armdroid.ui.theme.Purple200
import com.example.armdroid.ui.theme.Purple500
import com.example.armdroid.ui.theme.Purple700
import com.example.armdroid.ui.theme.SelectedTagCategory
import com.example.armdroid.ui.theme.Teal200
import com.example.armdroid.ui.theme.Teal700
import com.example.armdroid.ui.theme.TextColor
import com.example.armdroid.ui.theme.YbvrAlertDarkGreen
import com.example.armdroid.ui.theme.YbvrAlertDarkRed
import com.example.armdroid.ui.theme.YbvrAlertRed
import com.example.armdroid.ui.theme.YbvrDarkBlue200
import com.example.armdroid.ui.theme.YbvrSliderBackgroundColor
import com.example.armdroid.ui.theme.YbvrTagBackgroundColor
import com.example.armdroid.ui.theme.getAllCustomColorsWithNames
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPref {
    companion object {
        private lateinit var mSharedPref: SharedPreferences
        private lateinit var mSharedPrefFavouritesVideos: SharedPreferences
        private lateinit var mSharedPrefAppColors: SharedPreferences
        private lateinit var mSharedPrefImagesAccessTimes: SharedPreferences

        const val CONTENT_LIST_ENDPOINT = "com.ybvr.androidclient.CONTENT_LIST_ENDPOINT"
        const val VIRTUAL_TICKET_VALID_TICKET_ENDPOINT =
            "com.ybvr.androidclient.VIRTUAL_TICKET_VALID_TICKET_ENDPOINT"

        /**
         * Gets and initializes the shared preferences of the application using the APP context
         * @param context the application context
         */
        fun init(context: Context) {

            if (!::mSharedPref.isInitialized) {
                mSharedPref =
                    context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

            }
            if (!::mSharedPrefFavouritesVideos.isInitialized) {
                mSharedPrefFavouritesVideos =
                    context.getSharedPreferences("favourites", Context.MODE_PRIVATE)

            }


        }

        fun initColorsSharedPref(context: Context){
            if (!::mSharedPrefAppColors.isInitialized) {
                mSharedPrefAppColors =
                    context.getSharedPreferences("appColors", Context.MODE_PRIVATE)

            }
        }

        fun initImagesAccessTimesSharedPref(context: Context){
            if (!::mSharedPrefImagesAccessTimes.isInitialized) {
                mSharedPrefImagesAccessTimes =
                    context.getSharedPreferences("imagesAccessTimes", Context.MODE_PRIVATE)

            }
        }

        fun deleteColorsSharedPreferences(context: Context) {
            // Get SharedPreferences reference
            val sharedPreferences = context.getSharedPreferences("appColors", Context.MODE_PRIVATE)

            // Get SharedPreferences editor
            val editor = sharedPreferences.edit()

            // Remove the "appColors" SharedPreferences file
            editor.clear()
            editor.apply()
        }

        /**
         * This function reads the String value of the data that matches the [key] parameter and if it doesn't find it the function
         * will use the [defValue] instead.
         * @param key The key used to store the value to be read.
         * @param defValue Value to be used if there is no information stored with the key passed as input parameter. This [defValue] is a string.
         * @return Returns a String with either the value linked to the [key] or the [defValue].
         */
        fun readData(key: String, defValue: String): String? {
            return mSharedPref.getString(key, defValue)
        }

        /**
         * This function writes and stores the String data from [value] with [key] as a Key into the already Initialized Shared Preferences
         * @param key The key to be used in the future if we wanted to read this data from the Shared preferences
         * @param value the String data to be stored to be used later on
         */
        fun writeData(key: String, value: String) {
            val prefsEditor = mSharedPref.edit()
            prefsEditor.putString(key, value)
            prefsEditor.apply()
        }

        /**
         * This function reads the Boolean value of the data that matches the [key] parameter and if it doesn't find it the function
         * will use the [defValue] instead.
         * @param key The key used to store the value to be read.
         * @param defValue Value to be used if there is no information stored with the key passed as input parameter. This [defValue] is a Boolean.
         * @return Returns a Boolean with either the value linked to the [key] or the [defValue].
         */
        fun readData(key: String, defValue: Boolean): Boolean {
            return mSharedPref.getBoolean(key, defValue)
        }

        /**
         * This function writes and stores the Boolean data from [value] with [key] as a Key into the already Initialized Shared Preferences
         * @param key The key to be used in the future if we wanted to read this data from the Shared preferences
         * @param value the Boolean data to be stored to be used later on
         */
        fun writeData(key: String, value: Boolean) {
            val prefsEditor = mSharedPref.edit()
            prefsEditor.putBoolean(key, value)
            prefsEditor.apply()
        }

        /**
         * This function reads the Int value of the data that matches the [key] parameter and if it doesn't find it the function
         * will use the [defValue] instead.
         * @param key The key used to store the value to be read.
         * @param defValue Value to be used if there is no information stored with the key passed as input parameter. This [defValue] is an Int.
         * @return Returns a Int with either the value linked to the [key] or the [defValue].
         */
        fun readData(key: String, defValue: Int): Int {
            return mSharedPref.getInt(key, defValue)
        }

        /**
         * This function writes and stores the Int data from [value] with [key] as a Key into the already Initialized Shared Preferences
         * @param key The key to be used in the future if we wanted to read this data from the Shared preferences
         * @param value the Int data to be stored to be used later on
         */
        fun writeData(key: String, value: Int) {
            val prefsEditor = mSharedPref.edit()
            prefsEditor.putInt(key, value)
            prefsEditor.apply()
        }

        fun addVideoToFavourites(videoId: Int) {
            val editor = mSharedPrefFavouritesVideos.edit()
            editor.putInt(videoId.toString(), videoId)
            editor.apply()
        }
        fun addTimeOfLastAccessOfImageInCache(imageHash: String) {
            val editor = mSharedPrefImagesAccessTimes.edit()
            editor.putLong(imageHash, System.currentTimeMillis())
            editor.apply()
        }
        fun retrieveAllImagesAccessTimes(): MutableMap<String, *>? {
            return mSharedPrefImagesAccessTimes.all
        }
        fun removeAnImageAccessTime(imageHash:  String) {
            val editor = mSharedPrefImagesAccessTimes.edit()

            editor.remove(imageHash)
            editor.apply()
        }

        fun addColorsToSharedPref() {
            val gson = Gson()
            val colorsMap = getAllCustomColorsWithNames()
            val colorsJson = gson.toJson(colorsMap)
            val editor = mSharedPrefAppColors.edit()
            editor.putString("customColors", colorsJson)
            editor.apply()
        }

        inline fun <reified T> Gson.fromJson(json: String): T {
            return fromJson(json, object : TypeToken<T>() {}.type)
        }
        fun retrieveColorsFromSharedPref() {
            val savedColorsJson = mSharedPrefAppColors.getString("customColors", null)
            val savedColorsMap: Map<String, Color> = Gson().fromJson(savedColorsJson!!)

            Purple200 = savedColorsMap["Purple200"]?: DefaultColor
            Purple500 = savedColorsMap["Purple500"]?: DefaultColor
            Purple700 = savedColorsMap["Purple700"]?: DefaultColor
            Teal200 = savedColorsMap["Teal200"]?: DefaultColor
            Teal700 = savedColorsMap["Teal700"]?: DefaultColor
            TextColor = savedColorsMap["TextColor"]?: DefaultColor
            ColorPrimaryLight = savedColorsMap["ColorPrimaryLight"]?: DefaultColor
            ColorPrimary = savedColorsMap["ColorPrimary"]?: DefaultColor
            ColorPrimaryDark = savedColorsMap["ColorPrimaryDark"]?: DefaultColor
            Generic800 = savedColorsMap["Generic800"]?: DefaultColor
            Generic700 = savedColorsMap["Generic700"]?: DefaultColor
            Generic600 = savedColorsMap["Generic600"]?: DefaultColor
            Generic400 = savedColorsMap["Generic400"]?: DefaultColor
            GenericDivider = savedColorsMap["GenericDivider"]?: DefaultColor
            GenericAndroidWhiteLabelGenericBlack = savedColorsMap["GenericAndroidWhiteLabelGenericBlack"]?: DefaultColor
            ColorSecondaryLight = savedColorsMap["ColorSecondaryLight"]?: DefaultColor
            ColorSecondary = savedColorsMap["ColorSecondary"]?: DefaultColor
            ColorSecondaryDark = savedColorsMap["ColorSecondaryDark"]?: DefaultColor
            ColorPrimaryPastel = savedColorsMap["ColorPrimaryPastel"]?: DefaultColor
            SelectedTagCategory = savedColorsMap["SelectedTagCategory"]?: DefaultColor
            ColorAccentLight = savedColorsMap["ColorAccentLight"]?: DefaultColor
            ColorAccent = savedColorsMap["ColorAccent"]?: DefaultColor
            ColorAccentDark = savedColorsMap["ColorAccentDark"]?: DefaultColor
            IconColor = savedColorsMap["IconColor"]?: DefaultColor
        }

        fun removeVideoFromFavourites(videoId: Int) {
            val editor = mSharedPrefFavouritesVideos.edit()
            editor.remove(videoId.toString())
            editor.apply()
        }

        fun getFavouriteVideos(): List<Int> {
            return mSharedPrefFavouritesVideos.all.keys.map { it.toInt() }
        }
    }
}