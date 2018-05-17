package com.example.davegilbier.juanation.adapters


import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.davegilbier.juanation.R
import com.example.davegilbier.juanation.controllers.FastDonation_catClothing
import com.example.davegilbier.juanation.models.FastDonationContent
import com.example.davegilbier.juanation.models.ProfileMyDonationsContent

class FastDonationAdapter(
        private val mContext: Context,
        private val mFastDonationContent: ArrayList<FastDonationContent>) : RecyclerView.Adapter<FastDonationAdapter.ViewHolder>(){


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cat = mFastDonationContent[position]   //cat = category

        holder.category_title.text = mFastDonationContent[position].cTitle
//        holder.category_heading.text = mFastDonationContent[position].cHeading //trial and error
        Glide.with(mContext).load(cat.cPic).into(holder.imgCategory)

        holder.imgCategory.setOnClickListener({

            val intent = Intent(mContext, FastDonation_catClothing::class.java)
            intent.putExtra("title", cat.cTitle)
            intent.putExtra("get", cat.cPic)
//        intent.putExtra("head", cat.cHeading) //fs_donate_by_category


            mContext.startActivity(intent)
        })
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fast_donation_content, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mFastDonationContent.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCategory = itemView.findViewById<ImageView>(R.id.imgBtn_category)
        val category_title = itemView.findViewById(R.id.tV_category_title) as TextView
//        val category_heading = itemView.findViewById(R.id.tV_category_title) as TextView

    }

}
