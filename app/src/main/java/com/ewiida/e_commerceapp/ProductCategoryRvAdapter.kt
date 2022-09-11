package com.ewiida.e_commerceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.homeapp.homepage.itemFromCategoryDataClass

class ProductCategoryRvAdapter(arr:ArrayList<itemFromCategoryDataClass>):RecyclerView.Adapter<ProductCategoryRvAdapter.ProductViewHolder>() {
     var productList=arr

    var onItemClicked : ((itemFromCategoryDataClass) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var v= LayoutInflater.from(parent.context).inflate(R.layout.top_category_rv_layout,parent,false)
        return ProductViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var productItem=productList[position]
        holder.image.setImageResource(productItem.itemImage)
        holder.namee.text = productItem.itemName
        holder.des.text = productItem.itemDescription
        holder.price.text = productItem.itemPrice

        holder.itemView.setOnClickListener {
            onItemClicked?.invoke(productItem)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var image=itemView.findViewById<ImageView>(R.id.itemImage)
        var namee=itemView.findViewById<TextView>(R.id.itemName)
        var des=itemView.findViewById<TextView>(R.id.itemDescription)
        var price=itemView.findViewById<TextView>(R.id.itemPrice)
    }


}