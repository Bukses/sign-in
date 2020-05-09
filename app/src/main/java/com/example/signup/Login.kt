package com.example.signup

import PreferencesProvider
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.email
import kotlinx.android.synthetic.main.activity_main.*

class Login : AppCompatActivity() {

    private lateinit var preferencesProvider: PreferencesProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        preferencesProvider = PreferencesProvider(applicationContext)

         login.setOnClickListener{
             val eMail = email.setText(preferencesProvider.getString(Constants.KEY_EMAIL))
             val passWord = password.setText(preferencesProvider.getString(Constants.KEY_PASSWORD))

             val intent = Intent(this, Dashboard::class.java)
             startActivity(intent)


             if (eMail.equals(email.text.toString()) && passWord.equals(password.text.toString())){
                 Toast.makeText(applicationContext, "Data Saved!", Toast.LENGTH_LONG).show()
             }


         }





    }

}
