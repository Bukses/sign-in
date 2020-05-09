package com.example.signup

import Adapter
import SpaceItemdecoration
import android.content.Intent
import Model
import PreferencesProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_login.*


class Dashboard : AppCompatActivity() {

    lateinit var adapter: Adapter
    lateinit var itemList:MutableList<Model>
    private lateinit var preferencesProvider: PreferencesProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        initData()
        setData()
    }
    private fun setData() {
        adapter=Adapter(this,itemList)

        val layoutManager = GridLayoutManager(this, Common.NUM_OF_COLUMN, RecyclerView.VERTICAL, false)

        recyclerview.layoutManager=layoutManager
        recyclerview.addItemDecoration(SpaceItemdecoration(2))

        recyclerview.adapter=adapter

        recyclerview.setOnClickListener {
            email.setText(preferencesProvider.getString(Constants.KEY_EMAIL))

        }

    }
    private fun initData() {
        itemList=ArrayList()

        itemList.add(Model(R.drawable.android, "Android", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.chrome, "Browser", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.twitter, "Twitter", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.youtube, "Youtube", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.facebook, "Facebook", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.github, "Github", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.instagram, "Instagram", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.linkedin, "Linkedin", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.playstore, "Playstore", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.calendar, "Calendar", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.contact, "Contact", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.skype, "Skype", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.bitbucket, "Bitbucket", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.dribbble, "Dribbble", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.email, "E-mail", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.google, "Google", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.google_plus, "Google plus", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.skype, "Skype", uri = "https://android.com/"))
        itemList.add(Model(R.drawable.whatsapp, "Whatsapp", uri = "https://android.com/"))
    }

    override fun onStart() {
        super.onStart()
        Log.i("","onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.i("","onResume")

    }


    override fun onStop() {
        super.onStop()
        Log.i( "", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("","onDestroy")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("","onRestoreInstanceState")
    }

    fun onCartItemClick(view: View?, position: Int) {

        val intent= Intent()
        intent.action = Intent.ACTION_VIEW
        view?.context?.startActivity(Intent.createChooser(intent,"Open with"))
    }






}
