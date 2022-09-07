package com.ewiida.e_commerceapp.homeapp.homepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R

class item_fromCategory_rv(arr:ArrayList<itemFromCategoryDataClass>):RecyclerView.Adapter<item_fromCategory_rv.myViewHolder>() {
    var items=arr
    lateinit var sListener:onItemSelected
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): item_fromCategory_rv.myViewHolder {
        var v=LayoutInflater.from(parent.context).inflate(R.layout.top_category_rv_layout,parent,false)
        return myViewHolder(v,sListener)
    }

    override fun onBindViewHolder(holder: item_fromCategory_rv.myViewHolder, position: Int) {
        holder.image.setImageResource(items[position].itemImage)
        holder.namee.text=items[position].itemName
        holder.des.text=items[position].itemDescription
        holder.price.text=items[position].itemPrice
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class myViewHolder(itemView: View,listener:onItemSelected):RecyclerView.ViewHolder(itemView){
        var image=itemView.findViewById<ImageView>(R.id.itemImage)
        var namee=itemView.findViewById<TextView>(R.id.itemName)
        var des=itemView.findViewById<TextView>(R.id.itemDescription)
        var price=itemView.findViewById<TextView>(R.id.itemPrice)

        init {
            itemView.setOnClickListener{
                listener.onItemClicked(adapterPosition)
            }
        }
    }

    interface onItemSelected {
        fun onItemClicked(position: Int)
    }

    fun setOnItemSelected(l:onItemSelected){
        sListener=l
    }
}