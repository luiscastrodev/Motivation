package br.com.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.motivation.R
import br.com.motivation.infra.MotivationConstants
import br.com.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash_actvity.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurityPreferences = SecurityPreferences(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        textName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

        buttonNewPhrase.setOnClickListener(this)
        imageAll.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageMorning.setOnClickListener(this)

    }

    override fun onClick(v: View) {

        val id = v.id

        val listFilter = listOf(R.id.imageAll, R.id.imageHappy, R.id.imageMorning)

        if (id == R.id.buttonNewPhrase) {
            handleNewPhrase()
        } else if (id in listFilter) {
            handleFilter(id)
        }
    }

    private fun handleFilter(id: Int) {
        imageAll.setColorFilter(resources.getColor(R.color.white))
        imageHappy.setColorFilter(resources.getColor(R.color.white))
        imageMorning.setColorFilter(resources.getColor(R.color.white))

            when (id) {

            R.id.imageAll -> {
                imageAll.setColorFilter(resources.getColor(R.color.purple_200))
            }
            R.id.imageHappy -> {
                imageHappy.setColorFilter(resources.getColor(R.color.purple_200))

            }
            R.id.imageMorning -> {
                imageMorning.setColorFilter(resources.getColor(R.color.purple_200))

            }
        }
    }

    private fun handleNewPhrase() {
    }
}