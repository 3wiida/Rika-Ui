package com.ewiida.e_commerceapp.homeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R

class ProfileAdapter(private var itemList : List<ProfileItem>) : RecyclerView.Adapter<ProfileAdapter.MyViewHolder>() {

    var onItemClicked : ((ProfileItem) -> Unit)? = null

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemImage = itemView.findViewById<ImageView>(R.id.image)
        var itemTextView = itemView.findViewById<TextView>(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.profile_temp, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemImage.setImageResource(itemList[position].image)
        holder.itemTextView.text = item.name

        holder.itemView.setOnClickListener {
            onItemClicked?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}