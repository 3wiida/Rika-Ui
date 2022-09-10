package com.ewiida.e_commerceapp

import android.annotation.SuppressLint
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.homeapp.ProfileItem

class CategoryAdapter(private var itemList : List<CategoryItem>) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    var onItemClicked : ((CategoryItem) -> Unit)? = null

    inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var itemImage = itemView.findViewById<ImageView>(R.id.categoryImage)
        var itemName = itemView.findViewById<TextView>(R.id.categoryName)
        var itemDesc = itemView.findViewById<TextView>(R.id.categoryDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.category_temp, parent, false)
        return MyViewHolder(itemView)
    }

    @SuppressLint("RtlHardcoded")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemImage.setImageResource(itemList[position].image)

        if(position % 2 == 0){
            holder.itemName.text = item.name
            holder.itemDesc.text = item.num
            holder.itemName.gravity = Gravity.LEFT
            holder.itemDesc.gravity = Gravity.LEFT
        }else{
            holder.itemName.text = item.name
            holder.itemDesc.text = item.num
            holder.itemName.gravity = Gravity.RIGHT
            holder.itemDesc.gravity = Gravity.RIGHT
        }

        holder.itemView.setOnClickListener {
            onItemClicked?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}