package com.ewiida.e_commerceapp.homeapp.cartpage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R

class cart_items_rv_adabter(arr:ArrayList<cart_item_data_class>) :RecyclerView.Adapter<cart_items_rv_adabter.myViewHolder>(){
    var cartItems=arr
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cart_items_rv_adabter.myViewHolder {
        var v=LayoutInflater.from(parent.context).inflate(R.layout.cart_item_layout,parent,false)
        return myViewHolder(v)
    }

    override fun onBindViewHolder(holder: cart_items_rv_adabter.myViewHolder, position: Int) {
        holder.image.setImageResource(cartItems[position].img)
        holder.namee.text=cartItems[position].namee
        holder.des.text=cartItems[position].description
        holder.price.text="${cartItems[position].price.toString()} $"
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    inner class myViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var image=itemView.findViewById<ImageView>(R.id.cartitemimg)
        var namee=itemView.findViewById<TextView>(R.id.cartItemName)
        var des=itemView.findViewById<TextView>(R.id.cartItemDescription)
        var price=itemView.findViewById<TextView>(R.id.cartItemPrice)
        var minusOneBtn=itemView.findViewById<Button>(R.id.minusOneBtn)
    }
}