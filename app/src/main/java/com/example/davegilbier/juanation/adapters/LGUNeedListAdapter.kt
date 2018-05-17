package com.example.davegilbier.juanation.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.davegilbier.juanation.R
import com.example.davegilbier.juanation.models.LGUNeedList

class LGUNeedListAdapter(
        private val mContext: Context,
        private val mLGUNeedList: ArrayList<LGUNeedList>) : RecyclerView.Adapter<LGUNeedListAdapter.ViewHolder>() {

    //lateinit var array: Array<Editable>
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lguneedlist = mLGUNeedList[position]

        holder.list_txt.text = lguneedlist.needsList
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
        val v = LayoutInflater.from(parent.context).inflate(R.layout.urgentneeds_detail_content, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mLGUNeedList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val list_txt = itemView.findViewById(R.id.list_txt) as TextView
    }

}
