package com.example.davegilbier.juanation.controllers

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.davegilbier.juanation.MainActivity
import com.example.davegilbier.juanation.R
import com.example.davegilbier.juanation.adapters.FastDonationAdapter
import com.example.davegilbier.juanation.models.FastDonationContent
import kotlinx.android.synthetic.main.parent_menu_buttons.*

class FastDonation : AppCompatActivity() {

    private lateinit var mFastDonationAdapter: FastDonationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fast_donation)


        imgBtn_urgentNeeds.setOnClickListener({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

        imgBtn_fastDonation.setOnClickListener({
            val intent = Intent(this, FastDonation::class.java)
            startActivity(intent)
        })

        imgBtn_reccurDonation.setOnClickListener({
            val intent = Intent(this, MonetaryDonation::class.java)
            startActivity(intent)
        })

        imgBtn_profile.setOnClickListener({
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        })

        val myImageList = intArrayOf(R.drawable.category_rice, R.drawable.category_relief_goods, R.drawable.category_clothing, R.drawable.category_hygiene)

        //Needs filtering
        val arrayOfCategoryTitle = arrayOf(
                "RICE", "CAN GOODS", "CLOTHINGS", "PERSONAL HYGIENE"
        )



        mFastDonationAdapter =  FastDonationAdapter(this, ArrayList())
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager (this, LinearLayout.VERTICAL, false)
        val categoryList = ArrayList<FastDonationContent>()

        // send all data for display
        display(categoryList, myImageList, arrayOfCategoryTitle, recyclerView) //, arrayOfHeadings
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun display(fastDonationContentList: ArrayList<FastDonationContent>, myImageList: IntArray, arrayOfCategoryTitle: Array<String>, recyclerView: RecyclerView) { // arrayOfHeadings: Array<String> ,
        for (i in 0..3){
            var category_pic = myImageList[i]

            var category_title  = arrayOfCategoryTitle[i]

            recyclerView.adapter = FastDonationAdapter (this@FastDonation, fastDonationContentList)
            fastDonationContentList.add(FastDonationContent(category_title,category_pic))
        }
    }
}
