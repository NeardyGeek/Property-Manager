package com.nerdygeek.mvvm.ui.login

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nerdygeek.mvvm.data.AuthRepo
import com.nerdygeek.mvvm.data.models.User
import com.nerdygeek.mvvm.ui.AuthListener

class LoginViewModel: ViewModel() {
    var authListener: AuthListener? = null
    var email: String? = null
    var password: String? = null



    fun onLoginButtonClicked(view: View){
        authListener?.onStarted()
        if(email.isNullOrBlank() || password.isNullOrBlank()){
            authListener?.onFailure("all required")
        }else{

            var user = User(null, null,null,email!!,null,password!!, null)
            var response = AuthRepo().login(user)
            authListener?.onSuccess(response)
        }

    }


}