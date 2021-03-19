package com.nerdygeek.mvvm.ui

import androidx.lifecycle.MutableLiveData

interface AuthListener {

    fun onStarted()
    fun onSuccess(loginResponse: MutableLiveData<String>)
    fun onFailure(msg: String)
}