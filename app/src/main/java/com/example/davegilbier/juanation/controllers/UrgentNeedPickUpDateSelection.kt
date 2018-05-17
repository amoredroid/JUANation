package com.example.davegilbier.juanation.controllers

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.davegilbier.juanation.R
import com.example.davegilbier.juanation.adapters.NeedsListAdapter
import com.example.davegilbier.juanation.models.NeedsList
import kotlinx.android.synthetic.main.monetary_donation.*
import kotlinx.android.synthetic.main.urgentneeds_detail.*
import kotlinx.android.synthetic.main.urgentneeds_inputting.*
import kotlinx.android.synthetic.main.urgentneeds_transactionlist.*

class UrgentNeedPickUpDateSelection : AppCompatActivity() {
    private lateinit var mAdapter: NeedsListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.urgentneeds_transaction)


        backicon_btn.setOnClickListener({
            val intent = Intent(this, UrgentNeedChooseItemsToDonate::class.java)
            startActivity(intent)
        })


        val needsList = intent.getStringExtra("head")

/*

        itemname_txt.text = needsList
        quantity_txt.text = quantityEntered
*/


    }



}