package com.ewiida.e_commerceapp.homeapp.homepage

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R

class category_rv_adapter(private val context: Context, categoryList: ArrayList<SubCategoryModel>) :
    RecyclerView.Adapter<category_rv_adapter.myViewHolder>() {


    var onClickListener: ((SubCategoryModel) -> Unit)? = null
    var categoryList = categoryList

    private lateinit var cListener: onCategoryClicked

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): category_rv_adapter.myViewHolder {
        var v =
            LayoutInflater.from(parent.context).inflate(R.layout.category_layout_rv, parent, false)
        return myViewHolder(v, cListener)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: category_rv_adapter.myViewHolder, position: Int) {
        val item = categoryList[position]
        holder.categoryName.text = item.name
        if (item.selected) {
            holder.parent.background = (context.getDrawable(R.drawable._50_black_rect))
        } else {
            holder.parent.background = (context.getDrawable(R.drawable._50_white_rect_with_border))
        }
        holder.itemView.setOnClickListener {
            onClickListener?.invoke(item)
        }

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    //---------------------------View Holder----------------------->

    inner class myViewHolder(itemView: View, listener: onCategoryClicked) :
        RecyclerView.ViewHolder(itemView) {
        var categoryName = itemView.findViewById<TextView>(R.id.category)
        var parent = itemView.findViewById<ConstraintLayout>(R.id.parent_constraint)

        init {
            itemView.setOnClickListener {
                listener.onClick(adapterPosition)

            }
        }


    }

    //---------------------------item click listener---------------->
    interface onCategoryClicked {
        fun onClick(pos: Int)
    }

    fun setOnCategoryClickedListener(l: onCategoryClicked) {
        cListener = l
    }

    fun setList(list : ArrayList<SubCategoryModel>){
        this.categoryList = list
        notifyDataSetChanged()
    }
}