package com.example.davegilbier.juanation.controllers

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.davegilbier.juanation.R
import kotlinx.android.synthetic.main.fast_donation_catclothing.*

class FastDonation_catClothing : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fast_donation_catclothing)

        btnBack.setOnClickListener{
            val intent = Intent(this, FastDonation::class.java)
            startActivity(intent)
        }
//        imgBtn_category.setOnClickListener{
//            val intent = Intent(this, FS_Clothes::class.java)
//            startActivity(intent)
//        }



    }
}