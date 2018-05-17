package com.example.davegilbier.juanation.controllers

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.davegilbier.juanation.R
import kotlinx.android.synthetic.main.monetary_donation.*
import kotlinx.android.synthetic.main.monetary_monthly_recurring_screen.*
import kotlinx.android.synthetic.main.monetary_onetime_donation.*

class MonetaryDonationOneTime : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monetary_onetime_donation)


        backicon_btn.setOnClickListener({
            val intent = Intent(this, MonetaryDonation::class.java)
            startActivity(intent)
        })



        val enterAmount = onetime_txt.text

        proceed_btn.setOnClickListener({
            intent.putExtra("head", enterAmount.toString())
            val intent = Intent(this, Paypal::class.java)
            startActivity(intent)
        })

    }

}