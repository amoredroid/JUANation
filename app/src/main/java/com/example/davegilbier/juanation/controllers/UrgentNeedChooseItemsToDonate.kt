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
import kotlinx.android.synthetic.main.urgentneeds_inputting.*
import kotlinx.android.synthetic.main.urgentneeds_inputting_list.*


class UrgentNeedChooseItemsToDonate : AppCompatActivity() {



    private lateinit var mAdapter: NeedsListAdapter
    private lateinit var NeedsArray : Array<String>
 //  lateinit var arrayOfQtyEntered : Array<EditText>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.urgentneeds_inputting)



        val head = intent.getStringExtra("head")
        headline_txt2.text = head
        val imageName = intent.getIntExtra("get", 1)
        Glide.with(this).load(imageName).into(lgucalamity)

        val barangayAffected = intent.getStringExtra("brgy")
        // val calamityNeeds = intent.getStringArrayListExtra("calamity")
        val datePosted = intent.getStringExtra("datePosted")
        val postInfo = intent.getStringExtra("info")

        backicon_btn.setOnClickListener({
            val intent = Intent(this, UrgentNeedDetail::class.java)
            intent.putExtra("head", head)
            intent.putExtra("get", imageName)
            intent.putExtra("datePosted", datePosted)
            intent.putExtra("info", postInfo)
            intent.putExtra("brgy", barangayAffected)
            startActivity(intent)
        })



       // val arrayOfNeeds = intent.getStringArrayExtra("needs")
      ///  var arrayofneeds: Array<String>
      //  arrayofneeds = arrayOfNeeds
      //  val length = arrayofneeds.size
      //  for (i in 0..length){
      //      val needs = arrayofneeds[i]
      //  }
       // headline_txt2.text = length.toString()


        //Temporary data for now
        //  val arrayOfNeeds = arrayOf("1000 KILOS OF RICE","300 GLN DRINKING WATER","200 ADULT M SHIRTS","100 SACKS OF RICE","300 GLN DRINKING WATER","200 ADULT M SHIRTS","100 SACKS OF RICE","300 GLN DRINKING WATER","200 ADULT M SHIRTS")
        val arrayOfCount = arrayOf("200","120","100","50","120","100","50","120", "20")
        val calamityneeds = arrayOf("1000 kilos of rice",
                "300 gallons of drinking water",
                "200 adult male shirts",
                "300 adult female shirts",
                "200 sanitary napkins",
                "300 boxes of canned gods" ,
                "200 baby male shirts",
                "300 baby female shirts" ,
                "200 teen male shirts")

        // val arrayOfQty = arrayOf("","","","","","","","")
        // val length = arrayOfNeeds.size
        mAdapter = NeedsListAdapter(this, ArrayList())
        val recyclerView = findViewById<RecyclerView>(R.id.itemList_recylerView)
        recyclerView.layoutManager = LinearLayoutManager (this, LinearLayout.VERTICAL, false)
        val Needslist = ArrayList<NeedsList>()


        for (i in 0..8){
          var needslist_txt = calamityneeds[i]
            // var needslist_txt = NeedsArray[i]
            var needslistcount_txt = arrayOfCount [i]
            // var qty = arrayOfQty[i]
            //var qtyentered = arrayOfQtyEntered[i]
            recyclerView.adapter = NeedsListAdapter(this@UrgentNeedChooseItemsToDonate, Needslist)
            Needslist.add(NeedsList(needslist_txt, needslistcount_txt))
        }
            recyclerView.layoutManager = LinearLayoutManager(this)


        // btn.setOnClickListener(View.OnClickListener {
        //    val intent = Intent(this@MainActivity, NextActivity::class.java)
        //     startActivity(intent)
        //  })

        alldone_btn.setOnClickListener({
            val intent = Intent(this, UrgentNeedPickUpDateSelection::class.java)
            //intent.putExtra("all", Needslist)
            startActivity(intent)
        })
    }

}
