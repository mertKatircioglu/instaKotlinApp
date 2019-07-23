package com.example.instakotlin.utils

import android.content.Context
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.MenuItem
import com.example.instakotlin.Home.HomeActivity
import com.example.instakotlin.News.NewsActivity
import com.example.instakotlin.Profile.ProfileActivity
import com.example.instakotlin.R
import com.example.instakotlin.Search.SearchActivity
import com.example.instakotlin.Share.ShareActivity
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx

class BottomNavigationViewHelper {

    companion object{

        fun setUpBottomNavigationView(bottomNavigationViewEx: BottomNavigationViewEx){
            bottomNavigationViewEx.enableAnimation(false)
            bottomNavigationViewEx.enableItemShiftingMode(false)
            bottomNavigationViewEx.enableShiftingMode(false)
           // bottomNavigationViewEx.setTextVisibility(false) iconların altında ki başlıkların kalkması için
        }

        fun setUpNavitagion(context: Context, bottomNavigationViewEx: BottomNavigationViewEx){
            bottomNavigationViewEx.onNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener{
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when(item.itemId){
                        R.id.ic_home -> {

                            val intent = Intent(context,HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }
                        R.id.ic_search -> {

                            val intent = Intent(context,SearchActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }

                        R.id.ic_share ->{

                            val intent = Intent(context, ShareActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }
                        R.id.ic_news ->{

                            val intent = Intent(context, NewsActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }
                        R.id.ic_profile ->{
                            val intent = Intent(context,ProfileActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true

                        }
                    }

                    return false
            }

            }
        }
    }
}