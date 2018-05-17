package com.example.davegilbier.juanation.controllers

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.davegilbier.juanation.MainActivity
import com.example.davegilbier.juanation.R
import kotlinx.android.synthetic.main.parent_menu_buttons.*
import kotlinx.android.synthetic.main.profile.*

class Profile : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)


        btnBack.setOnClickListener({
            val intent = Intent(this, FastDonation::class.java)
            startActivity(intent)
        })


        btn_my_donations.setOnClickListener({
            val intent = Intent(this, ProfileMyDonations::class.java)
            startActivity(intent)
        })


    }



}