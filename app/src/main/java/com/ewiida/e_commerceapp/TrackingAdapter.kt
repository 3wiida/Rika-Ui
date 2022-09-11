package com.ewiida.e_commerceapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TrackingAdapter(private var itemList: List<TrackingItem>, var context: Context) : RecyclerView.Adapter<TrackingAdapter.MyViewHolder>() {
    inner class MyViewHolder(val itemView : View) : RecyclerView.ViewHolder(itemView) {
        var itemImage = itemView.findViewById<ImageView>(R.id.trackingItemImage)
        var itemNumber = itemView.findViewById<TextView>(R.id.trackingItemNumber)
        var itemAddress = itemView.findViewById<TextView>(R.id.trackingItemAddress)
        var itemStatus = itemView.findViewById<TextView>(R.id.trackingItemStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.tracking_item_temp, parent, false)
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemImage.setImageResource(item.image)
        holder.itemNumber.text = item.num
        holder.itemAddress.text = item.address
        holder.itemStatus.text = item.status

        when (item.status) {
            "Delivered" -> {
                holder.itemStatus.setTextColor(context.getColor(R.color._AAA))
            }
            "Transit" -> {
                holder.itemStatus.setTextColor(context.getColor(R.color.black))
            }
            else -> {
                holder.itemStatus.setTextColor(context.getColor(R.color._333))
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}