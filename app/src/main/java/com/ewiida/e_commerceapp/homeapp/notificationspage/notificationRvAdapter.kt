package com.ewiida.e_commerceapp.homeapp.notificationspage

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.homeapp.homepage.category_rv_adapter

class notificationRvAdapter(arr:ArrayList<notificatinDataClass>):RecyclerView.Adapter<notificationRvAdapter.myViewHolder>() {

    var notificationsList=arr
    override fun getItemCount(): Int {
        return notificationsList.size
    }

    override fun onBindViewHolder(holder: notificationRvAdapter.myViewHolder, position: Int) {
        holder.personImg.setImageResource(notificationsList[position].img)

        var notiContent="<b>"+notificationsList[position].namee+"<b>"+notificationsList[position].content
        var fontcolor="<b><font color='#000'>${notificationsList[position].namee}</font></b>"
        holder.nameAndContent.setText(Html.fromHtml(fontcolor+" "+notificationsList[position].content))
        holder.notiTime.text=notificationsList[position].time

        if(position==notificationsList.size-1){
            holder.itemView.background=null
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notificationRvAdapter.myViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.notifiaction_layout, parent, false)
        return myViewHolder(v)
    }

    inner class myViewHolder(itemview:View):RecyclerView.ViewHolder(itemview) {
        var personImg=itemview.findViewById<ImageView>(R.id.personImg)
        var nameAndContent=itemview.findViewById<TextView>(R.id.namePlusContent)
        var notiTime=itemview.findViewById<TextView>(R.id.notificationTime)
    }
}