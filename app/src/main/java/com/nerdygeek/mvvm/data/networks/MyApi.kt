package com.nerdygeek.mvvm.data.networks

import com.nerdygeek.mvvm.data.apps.Config
import com.nerdygeek.mvvm.data.models.LoginResponse
import com.nerdygeek.mvvm.data.models.RegistrationResponse
import com.nerdygeek.mvvm.data.models.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface MyApi {

    @POST("auth/register")
    suspend fun createUser(@Body user: User): Response<RegistrationResponse>

    @POST("auth/login")
    suspend fun loginUser(@Body user: User): Response<LoginResponse>

    companion object {
        operator fun invoke(): MyApi {
            return Retrofit.Builder().baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(MyApi::class.java)

        }
    }
}