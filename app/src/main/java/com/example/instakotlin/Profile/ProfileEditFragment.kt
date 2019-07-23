package com.example.instakotlin.Profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.instakotlin.R
import com.example.instakotlin.utils.UniversalImageLoader
import com.nostra13.universalimageloader.core.ImageLoader
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_profile_edit.*
import kotlinx.android.synthetic.main.fragment_profile_edit.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileEditFragment : Fragment() {

  lateinit var circleImageSetUpProfilePictureFragmen: CircleImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater!!.inflate(R.layout.fragment_profile_edit, container, false)

        circleImageSetUpProfilePictureFragmen = view.findViewById(R.id.circleProfileImage)
        setUpProfilepciture()



        view.imgClose.setOnClickListener {

            activity!!.onBackPressed()
        }
        return view
    }



    private fun setUpProfilepciture() {

        val imgUrl ="i350.photobucket.com/albums/q433/saikumarbhovi/veg%20%20bir_zpslsuhe0kr.jpg"

        UniversalImageLoader.setImage(imgUrl,circleImageSetUpProfilePictureFragmen,null,"https://")
    }


}
