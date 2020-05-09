package com.example.signup

import PreferencesProvider
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var preferencesProvider: PreferencesProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferencesProvider = PreferencesProvider(applicationContext)

        register.setOnClickListener {

            preferencesProvider.putString(Constants.KEY_EMAIL, email.text.toString())
            preferencesProvider.putString(Constants.KEY_PASSWORD, password.text.toString())
            preferencesProvider.putString(Constants.KEY_FIRST_NAME, firstname.text.toString())
            preferencesProvider.putString(Constants.KEY_LAST_NAME, lastname.text.toString())

            val intent = Intent (this, Login::class.java)
            startActivity(intent)


        }
    }
}
