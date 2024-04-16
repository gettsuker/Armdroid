package com.example.armdroid.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
var Purple200 = Color(0xFFBB86FC)
var Purple500 = Color(0xFF6200EE)
var Purple700 = Color(0xFF3700B3)
var Teal200 = Color(0xFF03DAC5)
var Teal700 = Color(0xFF018786)
var Black = Color(0xFF000000)
var White = Color(0xFFFFFFFF)
var TextColor = Color(0xFFFFFFFF)
var ColorPrimaryLight = Color(0xFF0B0A5C)
var ColorPrimary = Color(0xFF080741)
var ColorPrimaryDark = Color(0xFF080225)
var Generic800 = Color(0xFF1A1A1D)
var Generic700 = Color(0xFF22222A)
var Generic600 = Color(0xFF3E3E4C)
var Generic500 = Color(0xFF69696F)
var Generic400 = Color(0xFFC7C7C9)
var Generic300 = Color(0xFFD9D9DB)
var GenericDivider = Color(0xFF323232)
var GenericAndroidWhiteLabelGenericBlack = Color(0xFF000000)
var ColorSecondaryLight = Color(0xFF586DDA)
var ColorSecondary = Color(0xFF2A44BF)
var ColorSecondaryDark = Color(0xFF213597)
var ColorPrimaryPastel = Color(0xFF8A99E5)
var SelectedTagCategory = Color(0xFFD0BCFF)
var ColorAccentLight = Color(0xFFFF8847)
var ColorAccent = Color(0xFFFF5E08)
var ColorAccentDark = Color(0xFFCC4700)
var IconColor = Color(0xFFFFFFFF)
var DefaultColor = Color(0xFFFFFFFF)

fun getAllCustomColorsWithNames(): Map<String, Color> {
    return mapOf(
        "Purple200" to Purple200,
        "Purple500" to Purple500,
        "Purple700" to Purple700,
        "Teal200" to Teal200,
        "Teal700" to Teal700,
        "Black" to Black,
        "White" to White,
        "TextColor" to TextColor,
        "ColorPrimaryLight" to ColorPrimaryLight,
        "ColorPrimary" to ColorPrimary,
        "ColorPrimaryDark" to ColorPrimaryDark,
        "Generic800" to Generic800,
        "Generic700" to Generic700,
        "Generic600" to Generic600,
        "Generic500" to Generic500,
        "Generic400" to Generic400,
        "Generic300" to Generic300,
        "GenericDivider" to GenericDivider,
        "GenericAndroidWhiteLabelGenericBlack" to GenericAndroidWhiteLabelGenericBlack,
        "ColorSecondaryLight" to ColorSecondaryLight,
        "ColorSecondary" to ColorSecondary,
        "ColorSecondaryDark" to ColorSecondaryDark,
        "ColorPrimaryPastel" to ColorPrimaryPastel,
        "SelectedTagCategory" to SelectedTagCategory,
        "ColorAccentLight" to ColorAccentLight,
        "ColorAccent" to ColorAccent,
        "ColorAccentDark" to ColorAccentDark,
        "IconColor" to IconColor
    )
}