package com.example.davegilbier.juanation.controllers

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.davegilbier.juanation.R
import kotlinx.android.synthetic.main.monetary_donation.*
import kotlinx.android.synthetic.main.monetary_monthly_recurring_screen.*

class MonetaryDonationMonthlyRecurring : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monetary_monthly_recurring_screen)

        backicon_btn.setOnClickListener({
            val intent = Intent(this, MonetaryDonation::class.java)
            startActivity(intent)
        })




/*
        imgBtn_urgentNeeds.setOnClickListener({
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
            val intent = Intent(this, RecurringDonation::class.java)
            //  intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })

*/
        val enterAmount = enterAmount_txt.text
        procedd_btn.setOnClickListener({

           val intent = Intent(this, MonetaryDonationRecurringDateSelection::class.java)
           intent.putExtra("head", enterAmount.toString())
           //     //  intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
           startActivity(intent)
       })
    }
}