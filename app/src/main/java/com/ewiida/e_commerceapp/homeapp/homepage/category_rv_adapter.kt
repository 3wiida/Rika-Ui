package com.ewiida.e_commerceapp.homeapp.homepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R

class category_rv_adapter(categoryList:ArrayList<String>) : RecyclerView.Adapter<category_rv_adapter.myViewHolder>() {
    var categoryList=categoryList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): category_rv_adapter.myViewHolder {
        var v=LayoutInflater.from(parent.context).inflate(R.layout.category_layout_rv,parent,false)
        return myViewHolder(v)
    }

    override fun onBindViewHolder(holder: category_rv_adapter.myViewHolder, position: Int) {
        holder.categoryName.text=categoryList[position]
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    //---------------------------View Holder----------------------->

    inner class myViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var categoryName=itemView.findViewById<Button>(R.id.category)
    }
}