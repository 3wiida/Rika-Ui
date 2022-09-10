package com.ewiida.e_commerceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent

class OrderDetailsAdapter(private var itemList: List<OrderDetailsItem>) : RecyclerView.Adapter<OrderDetailsAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var itemName = itemView.findViewById<TextView>(R.id.orderDetailsItemName)
        var itemDesc = itemView.findViewById<TextView>(R.id.orderDetailsItemDesc)
        var itemPrice = itemView.findViewById<TextView>(R.id.orderDetailsItemPrice)
        var itemImage = itemView.findViewById<ImageView>(R.id.orderDetailsItemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.order_details_temp, parent, false)
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemName.text = item.name
        holder.itemDesc.text = item.desc
        holder.itemPrice.text = item.price
        holder.itemImage.setImageResource(itemList[position].image)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}