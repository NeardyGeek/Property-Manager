package com.nerdygeek.mvvm.data

import android.content.Context
import android.view.inputmethod.InlineSuggestionsRequest
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.nerdygeek.mvvm.data.models.LoginResponse
import com.nerdygeek.mvvm.data.models.RegistrationResponse
import com.nerdygeek.mvvm.data.models.User
import com.nerdygeek.mvvm.data.networks.MyApi
import kotlinx.coroutines.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Error


class AuthRepo() {



    val gson = Gson()

    var isLogged = MutableLiveData<Boolean>()


    fun register(user: User): MutableLiveData<String>{
        var registrationResponse = MutableLiveData<String>()
        val coroutineScope = CoroutineScope(Dispatchers.IO).launch {
            var response = MyApi().createUser(user)

            if(response.isSuccessful){

                registrationResponse.postValue(gson.toJson(response.body()))

            }else{
                registrationResponse.postValue(gson.toJson(response.errorBody()))
            }


        }
        return registrationResponse

    }

    fun login(user: User): MutableLiveData<String>{
        var loginResponse = MutableLiveData<String>()

        val coroutineScope = CoroutineScope(Dispatchers.IO).launch {
            var response = MyApi().loginUser(user)


            if(response.isSuccessful){
                isLogged.postValue(true)
                loginResponse.postValue(gson.toJson(response.body()))

            }else{

                loginResponse.postValue(gson.toJson(response.errorBody()))

            }


        }

        return loginResponse
    }




}