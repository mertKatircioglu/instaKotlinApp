package com.example.instakotlin.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.instakotlin.R
import com.example.instakotlin.utils.BottomNavigationViewHelper

import kotlinx.android.synthetic.main.activity_profile_settings.*

class ProfileSettingsActivity : AppCompatActivity() {

    private val ACTIVITY_NO = 4
    private val TAG = "ProfileActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_settings)


        setUpNavigationView()
        setupToolBar()
        fragmentNavigations()

    }

    private fun fragmentNavigations() {

        tvProfilDuzenle.setOnClickListener {

            // Profil ayarları activitysinde ki profil düzenle butonuna tıklayınca oluşturduğumuz fragmenti raplace etmek için
            //transcation yapısından faydalanıyoruz

            profileSettingsRoot.visibility = View.GONE // fragment çağrılınca ayalar sayfasında ki constrait layout görünmez oluyor
            var transacation = supportFragmentManager.beginTransaction()
            transacation.replace(R.id.profileSettignsContainer,ProfileEditFragment())
            transacation.addToBackStack("ProfilDuzenleFragmentEklendi")

            transacation.commit()
        }

        tvSignOut.setOnClickListener {

            profileSettingsRoot.visibility = View.GONE
            var transaciton = supportFragmentManager.beginTransaction()
            transaciton.replace(R.id.profileSettignsContainer,SignOutFragment())
            transaciton.addToBackStack("SignOutFragmentEklendi")
            transaciton.commit()
        }

    }

    private fun setupToolBar() {
        imgBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {

        profileSettingsRoot.visibility = View.VISIBLE
        super.onBackPressed()
    }

    fun setUpNavigationView(){
        //Bottom Menu itemleri için oluşturduğumuz ayar classını, bottom menu ile bağlıyoruz.
        BottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationProfileSetting)

        //Bottom Menu itemlara tıklandığında ne olacağını belirliyoruz
        BottomNavigationViewHelper.setUpNavitagion(this, bottomNavigationProfileSetting)


        var menu = bottomNavigationProfileSetting.menu
        var menuItem = menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }
}
