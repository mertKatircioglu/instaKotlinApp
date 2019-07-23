package com.example.instakotlin.Search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.instakotlin.R
import com.example.instakotlin.utils.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.activity_main.*

class SearchActivity : AppCompatActivity() {

    private val ACTIVITY_NO = 1
    private val TAG = "SearchActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpNavigationView()

    }

    fun setUpNavigationView(){
        //Bottom Menu itemleri için oluşturduğumuz ayar classını, bottom menu ile bağlıyoruz.
        BottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationView)

        //Bottom Menu itemlara tıklandığında ne olacağını belirliyoruz
        BottomNavigationViewHelper.setUpNavitagion(this, bottomNavigationView)


        var menu = bottomNavigationView.menu
        var menuItem = menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }
}
