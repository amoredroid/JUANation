package com.example.davegilbier.juanation.controllers

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.davegilbier.juanation.MainActivity
import com.example.davegilbier.juanation.R
import kotlinx.android.synthetic.main.parent_menu_buttons.*

class Paypal : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paypal)


  /*      imgBtn_urgentNeeds.setOnClickListener({
            val intent = Intent(this, MainActivity::class.java)
            //  intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })

        imgBtn_fastDonation.setOnClickListener({
            val intent = Intent(this, FastDonation::class.java)
            //  intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })

        imgBtn_reccurDonation.setOnClickListener({
            val intent = Intent(this, MonetaryDonation::class.java)
            //  intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })
    */



    }
}