package com.example.davegilbier.juanation.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import android.content.Intent
import com.example.davegilbier.juanation.models.LocalGovernmentUnit
import com.example.davegilbier.juanation.R
import com.example.davegilbier.juanation.controllers.UrgentNeedDetail


class Adapter(
        private val mContext: Context,
        private val mLocalGovernmentUnit: ArrayList<LocalGovernmentUnit>) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lgu = mLocalGovernmentUnit[position]

        holder.lguName_txt.text = mLocalGovernmentUnit[position].name
        holder.calamityHeadline_txt.text = mLocalGovernmentUnit[position].calamityHeadline
        Glide.with(mContext).load(lgu.lguLogo).into(holder.lgulogo_img)
        Glide.with(mContext).load(lgu.calamityPic).into(holder.lgucalamitypost_img)
        holder.dateposted_txt.text = mLocalGovernmentUnit[position].datePosted


       holder.lgucalamitypost_img.setOnClickListener({

            val intent = Intent(mContext, UrgentNeedDetail::class.java)
            intent.putExtra("head", lgu.calamityHeadline)
            intent.putExtra("get", lgu.calamityPic)
            intent.putExtra("brgy", lgu.barangayAffected)
            intent.putExtra("info", lgu.postInfo)
            intent.putExtra("calamity", lgu.calamityNeeds)
            intent.putExtra("datePosted", lgu.datePosted)

           // intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            mContext.startActivity(intent)
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.urgentneeds_content, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mLocalGovernmentUnit.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lgucalamitypost_img = itemView.findViewById<ImageView>(R.id.lgucalamitypost_btn)
        val lguName_txt = itemView.findViewById(R.id.lguName_txt) as TextView
        val lgulogo_img = itemView.findViewById<ImageView>(R.id.lgulogo_img)
        val calamityHeadline_txt = itemView.findViewById(R.id.calamityHeadline_txt) as TextView
        val dateposted_txt = itemView.findViewById(R.id.dateposted_txt) as TextView
    }
}
