package com.ewiida.e_commerceapp.homeapp.homepage.categoriespages

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.homeapp.homepage.ItemFromCategoryDataClass

class ProductCategoryRvAdapter(arr:ArrayList<ItemFromCategoryDataClass>):RecyclerView.Adapter<ProductCategoryRvAdapter.ProductViewHolder>() {

    private var productList = arr
    var onItemClicked : ((ItemFromCategoryDataClass) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.top_category_rv_layout,parent,false)
        return ProductViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productItem=productList[position]
        holder.image.setImageResource(productItem.itemImage)
        holder.name.text = productItem.itemName
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
        var image: ImageView = itemView.findViewById(R.id.itemImage)
        var name : TextView = itemView.findViewById(R.id.itemName)
        var des : TextView = itemView.findViewById(R.id.itemDescription)
        var price : TextView = itemView.findViewById(R.id.itemPrice)
    }


}