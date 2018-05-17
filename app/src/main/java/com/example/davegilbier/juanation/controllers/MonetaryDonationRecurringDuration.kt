package com.example.davegilbier.juanation.controllers

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.davegilbier.juanation.R
import kotlinx.android.synthetic.main.monetary_dateselection_recurringdonation.*
import kotlinx.android.synthetic.main.monetary_donation.*
import kotlinx.android.synthetic.main.monetary_duration_recurringdonation.*

class MonetaryDonationRecurringDuration : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monetary_duration_recurringdonation)


        backicon_btn.setOnClickListener({
            val intent = Intent(this, MonetaryDonationRecurringDateSelection::class.java)
            startActivity(intent)
        })


        val day = intent.getStringExtra("day")
        day_txt.text = day

        val amount = intent.getStringExtra("amount")
        amountt_txt.text = amount

        threemonths.setOnClickListener({
            val intent = Intent(this, Paypal::class.java)
            startActivity(intent)
        })
        sixmonths.setOnClickListener({
            val intent = Intent(this, Paypal::class.java)
            startActivity(intent)
        })
        ninemonths.setOnClickListener({
            val intent = Intent(this, Paypal::class.java)
            startActivity(intent)
        })
        year.setOnClickListener({
            val intent = Intent(this, Paypal::class.java)
            startActivity(intent)
        })


    }

}