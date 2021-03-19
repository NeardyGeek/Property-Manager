package com.nerdygeek.mvvm.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.nerdygeek.mvvm.R
import com.nerdygeek.mvvm.data.models.LoginResponse
import com.nerdygeek.mvvm.databinding.ActivityLoginBinding
import com.nerdygeek.mvvm.ui.AuthListener
import com.nerdygeek.mvvm.ui.home.HomeActivity

const val TAG = "la"
class LoginActivity : AppCompatActivity(), AuthListener {
    lateinit var mBinding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        mBinding.userInfo = viewModel
        viewModel.authListener = this


        init()
    }

    private fun init() {

    }

    override fun onStarted() {
        Log.d(TAG, "on started")
    }

    override fun onSuccess(loginResponse: MutableLiveData<String>) {
        loginResponse.observe(this, Observer {
            var response = Gson().fromJson(it, LoginResponse::class.java)
            Toast.makeText(applicationContext, response.user.toString(), Toast.LENGTH_LONG).show()
            startActivity(Intent(this, HomeActivity::class.java))


        })
    }

    override fun onFailure(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}