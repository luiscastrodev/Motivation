package br.com.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.motivation.R
import br.com.motivation.infra.MotivationConstants
import br.com.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash_actvity.*

class SplashActvity : AppCompatActivity(), View.OnClickListener {

    private lateinit var  mSecurityPreferences : SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_actvity)

        mSecurityPreferences = SecurityPreferences(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        buttonSave.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.buttonSave) {
            handleSave()
        }
    }

    private fun handleSave() {

        val name = edtName.text.toString()

        if (name != "") {
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Informe um nome", Toast.LENGTH_SHORT).show()
        }
    }
}