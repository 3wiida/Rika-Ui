package com.ewiida.e_commerceapp.ui.homeapp.homepage.categoriespages

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.ui.homeapp.homepage.SubCategoryModel

class CategoryRvAdapter(private val context: Context, private var categoryList: ArrayList<SubCategoryModel>) :
    RecyclerView.Adapter<CategoryRvAdapter.MyViewHolder>() {


    var onClickListener: ((SubCategoryModel) -> Unit)? = null

    private lateinit var cListener: OnCategoryClicked

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.category_layout_rv, parent, false)
        return MyViewHolder(v, cListener)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = categoryList[position]

        holder.categoryName.text = item.name

        if (item.selected) {

            holder.parent.background = (context.getDrawable(R.drawable._50_black_rect))
            holder.categoryName.setTextColor(context.getColor(R.color.white))

        }

        else {

            holder.categoryName.setTextColor(context.getColor(R.color.black))
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

    inner class MyViewHolder(itemView: View, listener: OnCategoryClicked) :
        RecyclerView.ViewHolder(itemView) {
        var categoryName: TextView = itemView.findViewById(R.id.category)
        var parent : ConstraintLayout = itemView.findViewById(R.id.parent_constraint)

        init {
            itemView.setOnClickListener {
                listener.onClick(adapterPosition)

            }
        }


    }

    //---------------------------item click listener---------------->
    interface OnCategoryClicked {
        fun onClick(pos: Int)
    }

    fun setOnCategoryClickedListener(l: OnCategoryClicked) {
        cListener = l
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list : ArrayList<SubCategoryModel>){
        this.categoryList = list
        notifyDataSetChanged()
    }
}