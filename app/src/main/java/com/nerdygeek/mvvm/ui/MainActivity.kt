package com.nerdygeek.mvvm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nerdygeek.mvvm.R
import com.nerdygeek.mvvm.data.AuthRepo
import com.nerdygeek.mvvm.ui.home.HomeActivity
import com.nerdygeek.mvvm.ui.login.LoginActivity
import com.nerdygeek.mvvm.ui.login.LoginViewModel
import com.nerdygeek.mvvm.ui.registration.RegistrationActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        AuthRepo().isLogged.observe(this, Observer {
            if(it){
                startActivity(Intent(this, HomeActivity::class.java))
            }
        })

        init()
    }

    private fun init() {
        btn_to_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btn_to_registration.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }


}