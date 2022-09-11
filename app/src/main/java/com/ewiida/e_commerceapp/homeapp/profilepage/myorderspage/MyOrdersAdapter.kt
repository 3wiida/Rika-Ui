package com.ewiida.e_commerceapp.homeapp.profilepage.myorderspage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R

class MyOrdersAdapter(private var itemList: List<Order>) : RecyclerView.Adapter<MyOrdersAdapter.MyViewHolder>() {

    var onItemClicked : ((Order) -> Unit)? = null

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemImage: ImageView = itemView.findViewById(R.id.orderImage)
        var itemName: TextView = itemView.findViewById(R.id.name)
        var itemModel: TextView = itemView.findViewById(R.id.model)
        var itemQuality: TextView = itemView.findViewById(R.id.quality)
        var itemSize: TextView = itemView.findViewById(R.id.size)
        var itemPrice : TextView = itemView.findViewById(R.id.price)
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
        holder.itemPrice.text = item.price

        holder.itemView.setOnClickListener {
            onItemClicked?.invoke(item)
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}