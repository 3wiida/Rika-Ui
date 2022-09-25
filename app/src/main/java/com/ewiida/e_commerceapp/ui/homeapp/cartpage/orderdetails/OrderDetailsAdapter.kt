package com.ewiida.e_commerceapp.ui.homeapp.cartpage.orderdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R

class OrderDetailsAdapter(private var itemList: List<OrderDetailsItem>) : RecyclerView.Adapter<OrderDetailsAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var itemName : TextView = itemView.findViewById(R.id.orderDetailsItemName)
        var itemDesc: TextView = itemView.findViewById(R.id.orderDetailsItemDesc)
        var itemPrice: TextView = itemView.findViewById(R.id.orderDetailsItemPrice)
        var itemImage: ImageView = itemView.findViewById(R.id.orderDetailsItemImage)
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