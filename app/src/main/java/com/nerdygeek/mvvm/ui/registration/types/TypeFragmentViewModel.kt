package com.nerdygeek.mvvm.ui.registration.types

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.nerdygeek.mvvm.data.AuthRepo
import com.nerdygeek.mvvm.data.models.User
import com.nerdygeek.mvvm.ui.AuthListener


class TypeFragmentViewModel() : ViewModel() {

    var authListener: AuthListener? = null


    var landlordEmail: String? = null
    var name: String? = null
    var email: String? = null
    var password: String? = null
    var type = "landlord"




    fun onRegisterButtonClick(view: View){
        authListener?.onStarted()

        if(email.isNullOrBlank() || name.isNullOrBlank() || password.isNullOrBlank()){
            authListener?.onFailure("sorry invalid")
        }else{
            var user = User(null, null,null,email!!,name,password!!, type)
            val loginResponse = AuthRepo().register(user)
            Log.d("abc", type)
            authListener?.onSuccess(loginResponse)
        }



    }











}