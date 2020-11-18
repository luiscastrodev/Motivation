package br.com.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_splash_actvity.*

class SplashActvity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_actvity)

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
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Informe um nome", Toast.LENGTH_SHORT).show()
        }
    }
}