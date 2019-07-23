package com.example.instakotlin.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.core.content.ContextCompat
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import com.example.instakotlin.R
import com.example.instakotlin.utils.EventbusDataEvents
import kotlinx.android.synthetic.main.activity_register.*
import org.greenrobot.eventbus.EventBus

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        init()
    }

    private fun init() {
        tvEposta.setOnClickListener {
            viewTelefon.visibility = View.INVISIBLE
            viewEposta.visibility = View.VISIBLE
            etGirisYontemi.setText("")
            etGirisYontemi.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            etGirisYontemi.setHint("E-posta")
            btnIler.isEnabled = false

        }

        tvTelefon.setOnClickListener {

            viewTelefon.visibility = View.VISIBLE
            viewEposta.visibility = View.INVISIBLE
            etGirisYontemi.setText("")
            etGirisYontemi.inputType = InputType.TYPE_CLASS_NUMBER
            etGirisYontemi.setHint("Telefon")
            btnIler.isEnabled = false


        }

        etGirisYontemi.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (start+before+count >= 11){
                    btnIler.isEnabled = true
                    btnIler.setTextColor(ContextCompat.getColor(this@RegisterActivity,R.color.beyaz))
                    btnIler.setBackgroundResource(R.drawable.register_button_source_aktif)

                } else {
                    btnIler.isEnabled = false
                    btnIler.setTextColor(ContextCompat.getColor(this@RegisterActivity,R.color.sonuMavi))
                    btnIler.setBackgroundResource(R.drawable.register_button_source)

                }
            }


        })

        btnIler.setOnClickListener {


           if(etGirisYontemi.hint.toString().equals("Telefon")){

               loginRoot.visibility = View.GONE
               loginContainer.visibility = View.VISIBLE
               var transaction = supportFragmentManager.beginTransaction()
               transaction.replace(R.id.loginContainer, TelefonKoduGirFragment())
               transaction.addToBackStack("telefonKoduGirFragmentEklendi")
               transaction.commit()

               // fragment veya activityeye veri gönderiyoruz
               EventBus.getDefault().postSticky(EventbusDataEvents.TelefonNoGonder(etGirisYontemi.text.toString()))

           }else{

               loginRoot.visibility = View.GONE
               loginContainer.visibility = View.VISIBLE
               var transaction = supportFragmentManager.beginTransaction()
               transaction.replace(R.id.loginContainer, EpostaGirisYontemiFragment())
               transaction.addToBackStack("EpostaGirFragmentEklendi")
               transaction.commit()

               EventBus.getDefault().postSticky(EventbusDataEvents.EmailGonder(etGirisYontemi.text.toString()))

           }
        }


    }

    override fun onBackPressed() {
        loginRoot.visibility = View.VISIBLE
        super.onBackPressed()
    }


}
