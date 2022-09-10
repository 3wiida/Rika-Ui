package com.ewiida.e_commerceapp

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
        var itemNameLeft = itemView.findViewById<TextView>(R.id.categoryNameLeft)
        var itemDescLeft = itemView.findViewById<TextView>(R.id.categoryDescLeft)
        var itemNameRight = itemView.findViewById<TextView>(R.id.categoryNameRight)
        var itemDescRight = itemView.findViewById<TextView>(R.id.categoryDescRight)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.category_temp, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemImage.setImageResource(itemList[position].image)

        if(position % 2 == 0){
            holder.itemNameLeft.text = item.name
            holder.itemDescLeft.text = item.num
            holder.itemNameRight.text = null
            holder.itemDescRight.text = null
        }else{
            holder.itemNameRight.text = item.name
            holder.itemDescRight.text = item.num
            holder.itemNameLeft.text = null
            holder.itemDescLeft.text = null
        }

        holder.itemView.setOnClickListener {
            onItemClicked?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}