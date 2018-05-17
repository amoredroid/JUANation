package com.example.davegilbier.juanation.controllers

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.davegilbier.juanation.MainActivity
import com.example.davegilbier.juanation.R
import com.example.davegilbier.juanation.R.id.sendhelp_btn
import com.example.davegilbier.juanation.adapters.LGUNeedListAdapter
import com.example.davegilbier.juanation.models.LGUNeedList
import kotlinx.android.synthetic.main.parent_menu_buttons.*
import kotlinx.android.synthetic.main.urgentneeds_detail.*


class UrgentNeedDetail : AppCompatActivity() {


    private lateinit var mAdapter: LGUNeedListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.urgentneeds_detail)

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


         val head = intent.getStringExtra("head")
         val imageName = intent.getIntExtra("get", 1)
         val barangayAffected = intent.getStringExtra("brgy")
        // val calamityNeeds = intent.getStringArrayListExtra("calamity")
         val datePosted = intent.getStringExtra("datePosted")
         val postInfo = intent.getStringExtra("info")

         val calamityNeeds = arrayOf("1000 kilos of rice",
                 "300 gallons of drinking water",
                 "200 adult male shirts",
                 "300 adult female shirts",
                 "200 sanitary napkins",
                 "300 boxes of canned gods" ,
                 "200 baby male shirts",
                 "300 baby female shirts" ,
                 "200 teen male shirts")


         headline_txt.text = head
         Glide.with(this).load(imageName).into(lgucalamity2)
         barangayAffected_text.text = barangayAffected
         postinfo_txt.text = postInfo
         //listofurgentneeds.text = calamityNeeds.toString()
         dateposted_txt.text = datePosted



        mAdapter =  LGUNeedListAdapter(this, ArrayList())
        val recyclerView = findViewById<RecyclerView>(R.id.needsRecycler)
        recyclerView.layoutManager = LinearLayoutManager (this, LinearLayout.VERTICAL, false)
        val lguneedlist = ArrayList<LGUNeedList>()
        // send all data for display
        display(lguneedlist,calamityNeeds,recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)




        sendhelp_btn.setOnClickListener({
            val intent = Intent(this, UrgentNeedChooseItemsToDonate::class.java)
            intent.putExtra("head", head)
            intent.putExtra("get", imageName)
            intent.putExtra("datePosted", datePosted)
            intent.putExtra("info", postInfo)
            intent.putExtra("brgy", barangayAffected)
                    startActivity(intent)
        })
    }

    private fun display(lguneedlist: ArrayList<LGUNeedList>, calamityNeeds: Array<String>, recyclerView: RecyclerView) {
        for (i in 0..8){
            var lguneed_txt = calamityNeeds[i]
            recyclerView.adapter = LGUNeedListAdapter (this, lguneedlist)
            lguneedlist.add(LGUNeedList(lguneed_txt))
        }
    }
}
