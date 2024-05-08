package com.example.armdroid.utils

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * The ToastController class is responsible for managing and controlling toast messages within the application.
 * It encapsulates the logic for displaying toasts with customizable messages, background colors, and durations.
 * This class operates within a specified [CoroutineScope], allowing asynchronous behavior for handling toast visibility and dismissal.
 *
 * @param scope The [CoroutineScope] in which the toast-related asynchronous operations will be executed.
 */
class ToastController @Inject constructor(private val scope: CoroutineScope) {
    val _show = mutableStateOf(false)
    val show: State<Boolean> get() = _show

    private val _message = mutableStateOf("")
    val message: State<String> get() = _message

    private val _backgroundColor = mutableStateOf(Color.Green)
    val backgroundColor: State<Color> get() = _backgroundColor


    /**
     * Displays a toast with the specified message, background color, and duration.
     *
     * @param message The text content of the toast message.
     * @param backgroundColor The background color of the toast, enhancing visual distinction.
     * @param duration The duration in milliseconds for which the toast remains visible before automatically dismissing.
     */
    fun showToast(message: String, backgroundColor: Color, duration: Long) {
        // Set the toast message, background color, and make the toast visible
        _message.value = message
        _backgroundColor.value = backgroundColor
        _show.value = true

        // Automatically dismiss the toast after the specified duration
        scope.launch {
            delay(duration)
            _show.value = false
        }
    }
}

/**
 * A CompositionLocal holding an instance of [ToastController] that can be accessed by composables within the composition hierarchy.
 * This local allows composables to interact with the [ToastController] and display toast messages within their respective scopes.
 * It provides a way for composables to access and use the shared instance of [ToastController] in a type-safe manner.
 * If no [ToastController] is found in the local composition, it defaults to null.
 */
val LocalToastController = staticCompositionLocalOf<ToastController?> { null }