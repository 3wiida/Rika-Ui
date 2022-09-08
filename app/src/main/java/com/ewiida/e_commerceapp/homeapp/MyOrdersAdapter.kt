package com.ewiida.e_commerceapp.homeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R

class MyOrdersAdapter(private var itemList: List<Order>) : RecyclerView.Adapter<MyOrdersAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemImage = itemView.findViewById<ImageView>(R.id.orderImage)
        var itemName = itemView.findViewById<TextView>(R.id.name)
        var itemModel = itemView.findViewById<TextView>(R.id.model)
        var itemQuality = itemView.findViewById<TextView>(R.id.quality)
        var itemSize = itemView.findViewById<TextView>(R.id.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.order_temp, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemImage.setImageResource(itemList[position].image)
        holder.itemName.text = item.name
        holder.itemModel.text = item.model
        holder.itemQuality.text = item.quality
        holder.itemSize.text = item.size
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}