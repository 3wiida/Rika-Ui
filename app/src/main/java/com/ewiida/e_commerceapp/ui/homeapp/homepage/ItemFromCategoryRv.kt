package com.ewiida.e_commerceapp.ui.homeapp.homepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R

class ItemFromCategoryRv(arr : ArrayList<ItemFromCategoryDataClass>) : RecyclerView.Adapter<ItemFromCategoryRv.MyViewHolder>() {

    private var items = arr
    private lateinit var sListener : OnItemSelected

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFromCategoryRv.MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.top_category_rv_layout, parent, false)
        return MyViewHolder(v, sListener)
    }

    override fun onBindViewHolder(holder: ItemFromCategoryRv.MyViewHolder, position: Int) {
        holder.image.setImageResource(items[position].itemImage)
        holder.name.text = items[position].itemName
        holder.des.text = items[position].itemDescription
        holder.price.text = items[position].itemPrice
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class MyViewHolder(itemView : View, listener:OnItemSelected):RecyclerView.ViewHolder(itemView){
        var image : ImageView = itemView.findViewById(R.id.itemImage)
        var name : TextView = itemView.findViewById(R.id.itemName)
        var des : TextView = itemView.findViewById(R.id.itemDescription)
        var price : TextView = itemView.findViewById(R.id.itemPrice)

        init {
            itemView.setOnClickListener{
                listener.onItemClicked(adapterPosition)
            }
        }
    }

    interface OnItemSelected {
        fun onItemClicked(position : Int)
    }

    fun setOnItemSelected(l : OnItemSelected){
        sListener = l
    }
}