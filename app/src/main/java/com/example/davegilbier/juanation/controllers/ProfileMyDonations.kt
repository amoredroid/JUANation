package com.example.davegilbier.juanation.controllers

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.davegilbier.juanation.R
import com.example.davegilbier.juanation.adapters.FastDonationAdapter
import com.example.davegilbier.juanation.adapters.ProfileMyDonationsAdapter
import com.example.davegilbier.juanation.models.ProfileMyDonationsContent
import kotlinx.android.synthetic.main.profile.*

class ProfileMyDonations : AppCompatActivity() {

    private lateinit var mProfileMyDonationsAdapter: ProfileMyDonationsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_mydonations)



        btnBack.setOnClickListener({
                    val intent = Intent(this, Profile::class.java)
                    startActivity(intent)
                })

        val myImageList = intArrayOf(R.drawable.talisay_logo, R.drawable.tuburan_logo, R.drawable.dumanjug_logo, R.drawable.pinamungahan_logo)

        //Needs filtering
        val arrayOfLGUNames = arrayOf(
                "Talisay", "Tuburan", "Dumanjug", "Pinamungahan"
        )

        val arrayOfHeadlines = arrayOf(
                "Fire Incident", "Flood Incident", "Fire Incident", "Flood Incident"
        )

        val arrayOfDateDonated = arrayOf(
                "Jan-05-16", "Jan-15-17", "Jan-05-15", "Jan-09-16"
        )



        mProfileMyDonationsAdapter =  ProfileMyDonationsAdapter(this, ArrayList())
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager (this, LinearLayout.VERTICAL, false)
        val categoryList = ArrayList<ProfileMyDonationsContent>()

        // send all data for display
        display(categoryList, myImageList, arrayOfLGUNames, arrayOfHeadlines, arrayOfDateDonated, recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun display(profileMyDonationsContentList: ArrayList<ProfileMyDonationsContent>, myImageList: IntArray, arrayOfLGUNames: Array<String>, arrayOfHeadlines: Array<String>, arrayOfDateDonated: Array<String>, recyclerView: RecyclerView) {
        for (i in 0..3){
            var imgProfile = myImageList[i]
            var lguName  = arrayOfLGUNames[i]
            var calamityHeadline  = arrayOfHeadlines[i]
            var calamityDate  = arrayOfDateDonated[i]

            recyclerView.adapter = FastDonationAdapter (this@ProfileMyDonations, profileMyDonationsContentList)
            profileMyDonationsContentList.add(ProfileMyDonationsContent(imgProfile, lguName,calamityHeadline, calamityDate))
        }
    }


}
