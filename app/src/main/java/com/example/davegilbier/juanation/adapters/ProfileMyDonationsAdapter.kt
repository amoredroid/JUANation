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
import com.example.davegilbier.juanation.models.ProfileMyDonationsContent

class ProfileMyDonationsAdapter (
        private val mContext: Context,
        private val mProfileMyDonationsContent: ArrayList<ProfileMyDonationsContent>) : RecyclerView.Adapter<ProfileMyDonationsAdapter.ViewHolder>(){


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cat = mProfileMyDonationsContent[position]

        holder.lguName.text = mProfileMyDonationsContent[position].lguName
        holder.calamityHeadline.text = mProfileMyDonationsContent[position].dHeadline
        Glide.with(mContext).load(cat.lguProfile).into(holder.imgProfile)
        holder.calamityDate.text = mProfileMyDonationsContent[position].dDate

        holder.imgProfile.setOnClickListener({

            val intent = Intent(mContext, FastDonation_catClothing::class.java)
            intent.putExtra("name", cat.lguName)
            intent.putExtra("get", cat.lguProfile)
            intent.putExtra("head", cat.dHeadline)
            intent.putExtra("date", cat.dDate)

            mContext.startActivity(intent)
        })
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.profile_mydonations_content, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mProfileMyDonationsContent.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProfile = itemView.findViewById<ImageView>(R.id.lgu_profile)
        val lguName = itemView.findViewById(R.id.lgu_name) as TextView
        val calamityHeadline = itemView.findViewById(R.id.donation_headline) as TextView
        val calamityDate = itemView.findViewById(R.id.donation_date) as TextView

    }

}
