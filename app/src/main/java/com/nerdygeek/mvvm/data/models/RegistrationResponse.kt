package com.nerdygeek.mvvm.data.models

data class RegistrationResponse(
    val data: User,
    val error: Boolean,
    val message: String
)

