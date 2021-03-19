package com.nerdygeek.mvvm.ui.registration.types

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TypeFragmentAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    private val types = mutableListOf("land lord", "tenant")

    override fun getCount(): Int {
        return types.size
    }

    override fun getItem(position: Int): Fragment {
        return TypeFragment.newInstance(types[position])
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return types[position]
    }


}