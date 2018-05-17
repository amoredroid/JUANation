package com.example.davegilbier.juanation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import com.example.davegilbier.juanation.adapters.Adapter
import com.example.davegilbier.juanation.controllers.FastDonation
import com.example.davegilbier.juanation.controllers.MonetaryDonation
import com.example.davegilbier.juanation.models.LocalGovernmentUnit
import kotlinx.android.synthetic.main.parent_menu_buttons.*


class MainActivity : AppCompatActivity() {


    private lateinit var mAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.urgentneeds_main)

        imgBtn_reccurDonation.setOnClickListener({
            val intent = Intent(this, MonetaryDonation::class.java)
            //  intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })
        imgBtn_fastDonation.setOnClickListener({
            val intent = Intent(this, FastDonation::class.java)
            //  intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })



        Log.e("", "Successfully entered the application.")

        // Temporary data only! After implementing the web service, all data should be dynamic.
        val myImageList = intArrayOf(R.drawable.fire, R.drawable.typhoon, R.drawable.earthquake)
        val logoList = intArrayOf(R.drawable.tuburan_logo, R.drawable.dumanjug_logo, R.drawable.pinamungahan_logo)
        val arrayOfLGU = arrayOf("Tuburan, Cebu", "Dumanjug, Cebu", "Pinamungahan, Cebu")
        val arrayOfHeadline = arrayOf("Barangay Dos: Under Fire! Maygad", "Poblacion: Massive flood from Typhoon Kapston", "Brgy. Gema:Mgntd 8.2 Earthquake")
        val arrayOfBarangayAffected = arrayOf("Barangay Dos, Tuburan, Cebu", "Barangay Poblacion, Dumanjug, Cebu", "Barangay Gema, Pinamungahan, Cebu")
        val arrayOfPostInfo = arrayOf("On April 28, 2018, a large fire caused by a lightning shocked the residents of Barangay Dos. Huge number of houses went to ashes." + "Currently, the victims are residing at Tuburan Plaza which served as their temporary evacuation centers. Due to the large number of" + " victims of the said crisis, lack of supplies especially in food, drinking water, and clothing has become a problem." + "The victims badly need help and assistance. ", "On April 27, 2018, Typhoon Kapston hit Poblacion, Dumajug. Massive casualties mentally, emotionally, socially and all existed." + "Currently, the victims are residing at Tuburan Plaza which served as their temporary evacuation centers. Due to the large number of" + " the victims of the said crisis, lack of supplies especially in food, drinking water, and clothing has become a problem." + "The victims badly need help and assistance.", "On April 27, 2018, Magnitude 8.1 earthquale shocked the residents of Barangay Dos. Huge number of houses went to ashes." + "Currently, the victims are residing at BCLs which served as their temporary evacuation centers. Due to the number of" + " victims of the said crisis, lack of supplies especially in food, drinking water, and clothing has become a problem." + "The victims badly need help and assistance. ")
        val arrayOfDatePosted = arrayOf("April 28, 2018 - 8:18 PM", "April 27, 2018 - 8:11 AM", "April 26, 2018 - 8:08 PM")

        /*val arrayofAllNeeds = arrayof(arrayOf("1000 kilos of rice\n300 gallons of drinking water\n200 adult male shirts\n300 adult female shirts\n200 sanitary napkins\n" + "300 boxes of canned gods\n" + "200 baby male shirts\n" + "300 baby female shirts\n" + "200 teen male shirts\n" + "300 teen female shirts\n" + "200 baby diapers"),
        arrayOf("9000  kilos of rice\n300 gallons of drinking water\n200 adult male shirts\n300 adult female shirts\n200 sanitary napkins\n" + "300 boxes of canned gods\n" + "200 baby male shirts\n" + "300 baby female shirts\n" + "200 teen male shirts\n" + "300 teen female shirts\n" + "200 baby diapers"),
        */

        //val arrayOfFirstLGUNeeds = arrayOf("9000 kilos of rice\n300 gallons of drinking water\n200 adult male shirts\n300 adult female shirts\n200 sanitary napkins\n" + "300 boxes of canned gods\n" + "200 baby male shirts\n" + "300 baby female shirts\n" + "200 teen male shirts\n" + "300 teen female shirts\n" + "200 baby diapers")
        //val arrayOfSecondLGUNeeds = arrayOf("9000  kilos of rice\n300 gallons of drinking water\n200 adult male shirts\n300 adult female shirts\n200 sanitary napkins\n" + "300 boxes of canned gods\n" + "200 baby male shirts\n" + "300 baby female shirts\n" + "200 teen male shirts\n" + "300 teen female shirts\n" + "200 baby diapers")
        //val arrayOfThirdLGUNeeds = arrayOf("8000 kilos of rice\n300 gallons of drinking water\n200 adult male shirts\n300 adult female shirts\n200 sanitary napkins\n" + "300 boxes of canned gods\n" + "200 baby male shirts\n" + "300 baby female shirts\n" + "200 teen male shirts\n" + "300 teen female shirts\n" + "200 baby diapers")

        val arrayOfFirstLGUNeeds = arrayOf("1000 kilos of rice",
                "300 gallons of drinking water",
                "200 adult male shirts",
                "300 adult female shirts",
                "200 sanitary napkins",
                "300 boxes of canned gods" ,
                "200 baby male shirts",
                "300 baby female shirts" ,
                "200 teen male shirts")
        val arrayOfSecondLGUNeeds = arrayOf("900 kilos of rice",
                "300 gallons of drinking water",
                "200 adult male shirts",
                "300 adult female shirts",
                "200 sanitary napkins",
                "300 boxes of canned gods" ,
                "200 baby male shirts",
                "300 baby female shirts" ,
                "200 teen male shirts")
        val arrayOfThirdLGUNeeds = arrayOf("800 kilos of rice",
                "300 gallons of drinking water",
                "200 adult male shirts",
                "300 adult female shirts",
                "200 sanitary napkins",
                "300 boxes of canned gods" ,
                "200 baby male shirts",
                "300 baby female shirts" ,
                "200 teen male shirts")



        val arrayOfNeeds = arrayOf(arrayOfFirstLGUNeeds, arrayOfSecondLGUNeeds, arrayOfThirdLGUNeeds)

        mAdapter =  Adapter(this, ArrayList())
        val recyclerView = findViewById<RecyclerView>(R.id.urgentNeedsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager (this, LinearLayout.VERTICAL, false)
        val lgulist = ArrayList<LocalGovernmentUnit>()
        // send all data for display
        display(lgulist, arrayOfLGU, myImageList, logoList, arrayOfHeadline, arrayOfBarangayAffected, arrayOfPostInfo, arrayOfNeeds,arrayOfDatePosted, recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


    }


    private fun display(lgulist: ArrayList<LocalGovernmentUnit>, arrayOfLGU: Array<String>, myImageList: IntArray, logoList: IntArray, arrayOfHeadline: Array<String>, arrayOfBarangayAffected: Array<String>, arrayOfPostInfo: Array<String>, arrayOfNeeds: Array<Array<String>>, arrayOfDatePosted: Array<String>, recyclerView: RecyclerView) {
        for (i in 0..2){
            var lguName_txt = arrayOfLGU[i]
            var calamityPic = myImageList[i]
            var lguLogo = logoList[i]
            var calamityHeadline = arrayOfHeadline[i]
            var barangayAffected = arrayOfBarangayAffected[i]
            var postInfo = arrayOfPostInfo[i]
            var calamityNeeds = arrayOfNeeds[i]
            var datePosted = arrayOfDatePosted[i]


            recyclerView.adapter = Adapter (this@MainActivity, lgulist)
            lgulist.add(LocalGovernmentUnit(lguName_txt,calamityPic, lguLogo, calamityHeadline, barangayAffected, postInfo, calamityNeeds, datePosted))
        }
    }


}













































/*    Log.e("SERVER", "SUCCESS")
runOnUiThread {
    var lengthCalamity = JSONObject(json).getJSONObject("type").length()

    Log.e("Final Exam", "$lengthCalamity")
    val lgulist = ArrayList<LocalGovernmentUnit>()
    for (i in 1..lengthCalamity) {
        Log.e("Final Exam", "$counter")

    //    var albumtext = JSONObject(json).getJSONObject("results").getJSONObject("albummatches").getJSONArray("album").getJSONObject(counter).getString("name")
      //  var calamityHeadline = JSONObject(json).getJSONObject("results").getJSONObject("albummatches").getJSONArray("album").getJSONObject(counter).getString("artist")
        var barangayAffected = JSONObject(json).getJSONObject("barangay")
        recyclerView.adapter = Adapter(this@MainActivity, lgulist)
        lgulist.add(LocalGovernmentUnit(barangayAffected))
        counter++

        Log.e("Final Exam", "$counter")
*/



                //   mAdapter = Adapter(this, ArrayList())
                //  val recyclerView = findViewById<RecyclerView>(R.id.urgentNeedsRecyclerView)
                //   recyclerView.layoutManager = LinearLayoutManager (this, LinearLayout.VERTICAL, false)
                //  val lgulist = ArrayList<LocalGovernmentUnit>()
                // send all data for display
                //   display(lgulist, arrayOfLGU, myImageList, logoList, arrayOfHeadline, arrayOfBarangayAffected, arrayOfPostInfo, arrayOfCalamityNeeds, arrayOfDatePosted, recyclerView)
               // recyclerView.layoutManager = LinearLayoutManager(this)




   /* private fun display(json: String?) {
        var lengthCalamity = JSONObject(json).getJSONObject("type").length()
        val calamityList = ArrayList<LocalGovernmentUnit>()
        for (i in 0..lengthCalamity){

            var lguname = JSONObject(json).getString("lguname")
          //  var lguName_txt = arrayOfLGU[i]
          //  var calamityPic = myImageList[i]
          //  var lguLogo = logoList[i]
          //  var calamityHeadline = arrayOfHeadline[i]
          //  var barangayAffected = arrayOfBarangayAffected[i]
          //  var postInfo = arrayOfPostInfo[i]
          //  var calamityNeeds  = arrayOfCalamityNeeds[i]
          //  var datePosted = arrayOfDatePosted[i]

            recyclerView.adapter = Adapter(this@MainActivity, calamityList)
            calamityList.add(LocalGovernmentUnit(lguname))
        }
    }
}*/





