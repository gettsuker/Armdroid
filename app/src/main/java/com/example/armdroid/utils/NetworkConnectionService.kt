package com.example.armdroid.utils

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.armdroid.utils.NetworkManager.isOnline
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/*
 * Class used to manage the service that is in charge of checking the internet connection status after every X time.
 * The time is decided by the value of the constant (TIME_NEEDED_TO_CHECK_INTERNET_CONNECTION).
 * @param context context of the application, used to run the [isOnline] method of the networkManager
 */
class NetworkConnectionService  constructor(context: Context, override val coroutineContext: CoroutineContext) : CoroutineScope {
    val _errorCode = MutableLiveData<Int>(0)
    var errorCode : LiveData<Int> = _errorCode
    private val runnable = Runnable {
        if (!isOnline()){
            _errorCode.postValue(2)
        }
    }

    private var coroutine: Job? = null

    /*
     * Function that starts the service. Since the service is started in the Main activity it is tracked through the whole application because
     * this application just has one activity due to being made in kotlin
     */
    fun start() {
        if(coroutine!=null){
            coroutine?.cancel()
        }
        coroutine = launch {
            while (coroutine?.isActive == true) {
                runnable.run()
                delay(Constants.timeNeededToCheckInternetConnection.toLong())
            }
        }
    }
    /*
     * Function that stops the service. Since the service is started in the Main activity it is tracked through the whole application because
     * this application just has one activity due to being made in kotlin
     */
    fun stop() {
        coroutine?.cancel()
    }
}