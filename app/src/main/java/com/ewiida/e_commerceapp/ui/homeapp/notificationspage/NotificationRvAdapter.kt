package com.ewiida.e_commerceapp.ui.homeapp.notificationspage

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R

class NotificationRvAdapter(arr:ArrayList<NotificationDataClass>):RecyclerView.Adapter<NotificationRvAdapter.MyViewHolder>() {

    private var notificationsList = arr

    override fun getItemCount(): Int {
        return notificationsList.size
    }

    override fun onBindViewHolder(holder: NotificationRvAdapter.MyViewHolder, position: Int) {
        holder.personImg.setImageResource(notificationsList[position].img)

        val fontColor="<b><font color='#000'>${notificationsList[position].name}</font></b>"

        holder.nameAndContent.text = Html.fromHtml(fontColor + " " + notificationsList[position].content)
        holder.notTime.text=notificationsList[position].time

        if(position==notificationsList.size-1){
            holder.itemView.background=null
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationRvAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.notifiaction_layout, parent, false)
        return MyViewHolder(v)
    }

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var personImg : ImageView = itemView.findViewById(R.id.personImg)
        var nameAndContent : TextView = itemView.findViewById(R.id.namePlusContent)
        var notTime : TextView = itemView.findViewById(R.id.notificationTime)
    }
}