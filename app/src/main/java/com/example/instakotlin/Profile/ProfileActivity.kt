package com.example.instakotlin.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.instakotlin.R
import com.example.instakotlin.utils.BottomNavigationViewHelper
import com.example.instakotlin.utils.UniversalImageLoader
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile_settings.*


class ProfileActivity : AppCompatActivity() {

    private val ACTIVITY_NO = 4
    private val TAG = "ProfileActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setUpNavigationView()
        setupToolBar()
        setUpProfilePhoto()

    }

    private fun setUpProfilePhoto() {
        val imgUrl ="i350.photobucket.com/albums/q433/saikumarbhovi/veg%20%20bir_zpslsuhe0kr.jpg"

        UniversalImageLoader.setImage(imgUrl,circleProfileImage,progressBar,"https://")
    }

    fun setupToolBar() {
         imgProfilSeetings.setOnClickListener {
             var intent = Intent(this, ProfileSettingsActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
             startActivity(intent)
         }

         tvProfilDuzenleButton.setOnClickListener {
             profilRoot.visibility = View.GONE // fragment çağrılınca ayalar sayfasında ki constrait layout görünmez oluyor
             var transacation = supportFragmentManager.beginTransaction()
             transacation.replace(R.id.profilContainer,ProfileEditFragment())
             transacation.addToBackStack("ProfilDuzenleFragmentEklendi")

             transacation.commit()
         }

    }

    override fun onBackPressed() {

        profilRoot.visibility = View.VISIBLE
        super.onBackPressed()
    }

    fun setUpNavigationView(){
        //Bottom Menu itemleri için oluşturduğumuz ayar classını, bottom menu ile bağlıyoruz.
        BottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationViewProfile)

        //Bottom Menu itemlara tıklandığında ne olacağını belirliyoruz
        BottomNavigationViewHelper.setUpNavitagion(this, bottomNavigationViewProfile)


        var menu = bottomNavigationViewProfile.menu
        var menuItem = menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }
}
