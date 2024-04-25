package com.example.foodapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class res_list_adapter(val context:Context,val arrayList: ArrayList<String>):RecyclerView.Adapter<res_list_adapter.homeViewholder>()
{
    class homeViewholder(view:View):RecyclerView.ViewHolder(view){
        val textView: TextView =view.findViewById(R.id.Name)
        val resName: TextView =view.findViewById(R.id.name)
        var price: TextView =view.findViewById(R.id.Price)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): homeViewholder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.view_home,parent,false)
        return homeViewholder(view)
    }
    override fun getItemCount(): Int {
        return arrayList.size
    }
    override fun onBindViewHolder(holder: homeViewholder, position: Int) {
        val itemlist=arrayList[position]

    }

}