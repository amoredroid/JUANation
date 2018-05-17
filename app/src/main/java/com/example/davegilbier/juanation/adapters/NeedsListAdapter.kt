package com.example.davegilbier.juanation.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.davegilbier.juanation.models.NeedsList
import com.example.davegilbier.juanation.R
import com.example.davegilbier.juanation.controllers.UrgentNeedDetail
import com.example.davegilbier.juanation.controllers.UrgentNeedPickUpDateSelection
import android.text.TextWatcher




class NeedsListAdapter(
        private val mContext: Context,
        private val mNeedsList: ArrayList<NeedsList>) : RecyclerView.Adapter<NeedsListAdapter.ViewHolder>() {

    //lateinit var array: Array<Editable>
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val needlist = mNeedsList[position]

        holder.needlist_txt.text = needlist.needsList
        holder.needlistcount_txt.text = needlist.needsListCount
      //  holder.enterQty.text = needlist.qtyEntered as Editable
     //   holder.addbtn.setOnClickListener({
     //      // holder.enterQty.text= needlist.toDonate as Editable
    //        holder.enterQty.text = array[position]
     //   })



       /*holder.alldonebtn.setOnClickListener({
            val intent = Intent(mContext, UrgentNeedPickUpDateSelection::class.java)
                intent.putExtra("needlist", needlist.needsList)
                intent.putExtra("quantityEntered", needlist.numberOfNeedsToDonate )
            mContext.startActivity(intent)
        })*/

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.urgentneeds_inputting_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mNeedsList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val needlist_txt = itemView.findViewById(R.id.needlist_txt) as TextView
        val needlistcount_txt = itemView.findViewById(R.id.needlistcount_txt) as TextView
        val addbtn = itemView.findViewById<Button>(R.id.addbutton)
        var enterQty = itemView.findViewById<EditText>(R.id.enterQuantity)

    }

}
