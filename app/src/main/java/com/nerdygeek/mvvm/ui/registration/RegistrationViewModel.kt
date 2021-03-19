package com.nerdygeek.mvvm.ui.registration

import androidx.lifecycle.ViewModel

class RegistrationViewModel: ViewModel() {

    val types = ArrayList<String>()

    fun create(){
        types.add("land lord")
        types.add("tenant")
    }




}