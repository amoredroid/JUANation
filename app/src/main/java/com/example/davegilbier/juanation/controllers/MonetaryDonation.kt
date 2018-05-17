package com.example.davegilbier.juanation.controllers

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.davegilbier.juanation.MainActivity
import com.example.davegilbier.juanation.R
import kotlinx.android.synthetic.main.monetary_donation.*

class MonetaryDonation : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monetary_donation)


        backicon_btn.setOnClickListener({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })


        monthly_btn.setOnClickListener({
            val intent = Intent(this, MonetaryDonationMonthlyRecurring::class.java)
            startActivity(intent)
        })

        onetime_btn.setOnClickListener({
            val intent = Intent(this, MonetaryDonationOneTime::class.java)
            startActivity(intent)
        })

    }

}