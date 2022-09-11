package com.ewiida.e_commerceapp.homeapp.cartpage

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R

class CartItemsRvAdapter(arr: ArrayList<CartItemDataClass>) : RecyclerView.Adapter<CartItemsRvAdapter.MyViewHolder>() {

    var cartItems = arr
    var bundle: Bundle = Bundle()

    var onRemoveListener: ((CartItemDataClass) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemsRvAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cart_item_layout, parent, false)
        return MyViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CartItemsRvAdapter.MyViewHolder, position: Int) {
        holder.image.setImageResource(cartItems[position].img)
        holder.name.text = cartItems[position].name
        holder.des.text = cartItems[position].description
        holder.price.text = "${cartItems[position].price} $"

        holder.minusOneBtn.setOnClickListener {
            onRemoveListener?.invoke(cartItems[position])
        }

    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun removeItem(cartItemDataClass: CartItemDataClass) {
        cartItems.removeIf {
            it.name==cartItemDataClass.name
        }
        notifyDataSetChanged()
    }


    @SuppressLint("NotifyDataSetChanged")
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image : ImageView = itemView.findViewById(R.id.cartitemimg)
        var name : TextView = itemView.findViewById(R.id.cartItemName)
        var des : TextView = itemView.findViewById(R.id.cartItemDescription)
        var price : TextView = itemView.findViewById(R.id.cartItemPrice)
        var minusOneBtn : Button = itemView.findViewById(R.id.minusOneBtn)

        init {
            itemView.findViewById<Button>(R.id.minusOneBtn).setOnClickListener {
                cartItems.removeAt(adapterPosition)
                notifyDataSetChanged()
                var totalPrice = 0
                for (i in cartItems) {
                    totalPrice += i.price
                }
                bundle.putInt("totalPrice", totalPrice)
            }
        }
    }
}