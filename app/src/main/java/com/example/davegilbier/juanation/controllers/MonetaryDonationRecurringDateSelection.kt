package com.example.davegilbier.juanation.controllers

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.davegilbier.juanation.R
import kotlinx.android.synthetic.main.monetary_dateselection_recurringdonation.*
import kotlinx.android.synthetic.main.monetary_donation.*
import kotlinx.android.synthetic.main.urgentneeds_inputting.*

class MonetaryDonationRecurringDateSelection : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monetary_dateselection_recurringdonation)


        val head = intent.getStringExtra("head")
        amount_txt.text = head

        backicon_btn.setOnClickListener({
            val intent = Intent(this, MonetaryDonationMonthlyRecurring::class.java)
            intent.putExtra("head", head)
            startActivity(intent)
        })



        fifth.setOnClickListener({
            val intent = Intent(this, MonetaryDonationRecurringDuration::class.java)
            val day = "Every 5th of the month."
            intent.putExtra("day", day)
            intent.putExtra("amount", head)
            startActivity(intent)
        })
        tenth.setOnClickListener({
            val intent = Intent(this, MonetaryDonationRecurringDuration::class.java)
            val day = "Every 10th of the month."
            intent.putExtra("day", day)
            intent.putExtra("amount", head)

            startActivity(intent)
        })
        fifteenth.setOnClickListener({
            val intent = Intent(this, MonetaryDonationRecurringDuration::class.java)
            val day = "Every 15th of the month."
            intent.putExtra("day", day)
            intent.putExtra("amount", head)

            startActivity(intent)
        })
        twentieth.setOnClickListener({
            val intent = Intent(this, MonetaryDonationRecurringDuration::class.java)
            val day = "Every 20th of the month."
            intent.putExtra("day", day)
            intent.putExtra("amount", head)

            startActivity(intent)
        })
        twentfifth.setOnClickListener({
            val intent = Intent(this, MonetaryDonationRecurringDuration::class.java)
            val day = "Every 25th of the month."
            intent.putExtra("day", day)
            intent.putExtra("amount", head)

            startActivity(intent)
        })
        thirtieth.setOnClickListener({
            val intent = Intent(this, MonetaryDonationRecurringDuration::class.java)
            val day = "Every 30th of the month."
            intent.putExtra("day", day)
            intent.putExtra("amount", head)

            startActivity(intent)
        })

    }
}