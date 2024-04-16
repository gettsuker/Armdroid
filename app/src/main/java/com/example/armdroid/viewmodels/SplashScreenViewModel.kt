package com.example.armdroid.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashScreenViewModel : ViewModel() {
    var _errorCode = MutableLiveData<Int>(0)
    val errorCode: LiveData<Int> = _errorCode
}