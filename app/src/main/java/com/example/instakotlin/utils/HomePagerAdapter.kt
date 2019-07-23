package com.example.instakotlin.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomePagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {


    private var mFragmentList : ArrayList<Fragment> = ArrayList()

    //fragment pager adapterın yazmayı zorunlu kıldığı fonskiyon
    override fun getItem(p0: Int): Fragment {


       return mFragmentList.get(p0)
    }

    override fun getCount(): Int {

        return mFragmentList.size
    }

    //kişisel fragmen
    fun addFragment(fragment: Fragment){
        mFragmentList.add(fragment)
    }
 }