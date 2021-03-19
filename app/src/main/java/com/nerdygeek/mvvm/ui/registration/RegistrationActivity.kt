package com.nerdygeek.mvvm.ui.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nerdygeek.mvvm.R
import com.nerdygeek.mvvm.ui.registration.types.TypeFragment
import com.nerdygeek.mvvm.ui.registration.types.TypeFragmentAdapter
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        init()
    }

    private fun init() {
        var typeFragmentAdapter = TypeFragmentAdapter(supportFragmentManager)
        view_pager.adapter = typeFragmentAdapter
        tab_layout.setupWithViewPager(view_pager)
    }
}