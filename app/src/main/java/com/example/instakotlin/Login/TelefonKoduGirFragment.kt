package com.example.instakotlin.Login


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.instakotlin.R
import com.example.instakotlin.utils.EventbusDataEvents
import kotlinx.android.synthetic.main.fragment_telefon_kodu_gir.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class TelefonKoduGirFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.fragment_telefon_kodu_gir, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        EventBus.getDefault().register(this)
    }

    @Subscribe (sticky = true)
    internal fun onTelefonNoEvent(telefonNumarasi: EventbusDataEvents.TelefonNoGonder){
        var gelenTelNo = telefonNumarasi.telNo
        tvTEL.text = "adasdas"
    }


    override fun onDetach() {

        EventBus.getDefault().unregister(this)
        super.onDetach()
    }


}
