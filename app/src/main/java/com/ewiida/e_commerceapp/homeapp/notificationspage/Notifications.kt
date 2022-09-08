package com.ewiida.e_commerceapp.homeapp.notificationspage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentNotificationsBinding
import com.ewiida.e_commerceapp.homeapp.homepage.Home
import kotlin.math.log


class Notifications : Fragment() {

    lateinit var binding : FragmentNotificationsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notifications, container, false)
        return return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notificationRecyclerViewHandler()
        Log.d("tag","test")
        binding.backBtn.setOnClickListener{
            var f=Home()
            var fm=activity?.supportFragmentManager
            var ft=fm?.beginTransaction()
            ft?.replace(R.id.container,f)
            ft?.commit()
            var bnb=activity?.findViewById<github.com.st235.lib_expandablebottombar.ExpandableBottomBar>(R.id.bottomNavigationView)
            bnb?.menu?.select(R.id.menuItemHome)
        }
    }


    fun notificationRecyclerViewHandler(){
        var notifications=ArrayList<notificatinDataClass>()
        notifications.add(element = notificatinDataClass(R.drawable.manimage, "Mahmoud ewida","It is a long established fact\n" +
                "that a reader will be distracted by the\n" +
                "readable content of a page","2 hours ago"))
        notifications.add(element = notificatinDataClass(R.drawable.womanimage, "Abd El-Halem","There are many variations of \n" +
                "passages of Lorem Ipsum available.","2 hours ago"))
        notifications.add(element = notificatinDataClass(R.drawable.manimage, "Yousef Hassan"," If you are going to use a\n" +
                "passage of Lorem Ipsum, you need to be sure\n" +
                "there isn't anything embarrassing.","2 hours ago"))
        notifications.add(element = notificatinDataClass(R.drawable.manimage, "Mahmoud ewida","It is a long established fact\n" +
                "that a reader will be distracted by the\n" +
                "readable content of a page","2 hours ago"))
        notifications.add(element = notificatinDataClass(R.drawable.womanimage, "Abd El-Halem","There are many variations of \n" +
                "passages of Lorem Ipsum available.","2 hours ago"))
        notifications.add(element = notificatinDataClass(R.drawable.manimage, "Yousef Hassan"," If you are going to use a\n" +
                "passage of Lorem Ipsum, you need to be sure\n" +
                "there isn't anything embarrassing.","2 hours ago"))
        notifications.add(element = notificatinDataClass(R.drawable.manimage, "Mahmoud ewida","It is a long established fact\n" +
                "that a reader will be distracted by the\n" +
                "readable content of a page","2 hours ago"))
        notifications.add(element = notificatinDataClass(R.drawable.womanimage, "Abd El-Halem","There are many variations of \n" +
                "passages of Lorem Ipsum available.","2 hours ago"))
        notifications.add(element = notificatinDataClass(R.drawable.manimage, "Yousef Hassan"," If you are going to use a\n" +
                "passage of Lorem Ipsum, you need to be sure\n" +
                "there isn't anything embarrassing.","2 hours ago"))
        notifications.add(element = notificatinDataClass(R.drawable.manimage, "Mahmoud ewida","It is a long established fact\n" +
                "that a reader will be distracted by the\n" +
                "readable content of a page","2 hours ago"))
        notifications.add(element = notificatinDataClass(R.drawable.womanimage, "Abd El-Halem","There are many variations of \n" +
                "passages of Lorem Ipsum available.","2 hours ago"))
        notifications.add(element = notificatinDataClass(R.drawable.manimage, "Yousef Hassan"," If you are going to use a\n" +
                "passage of Lorem Ipsum, you need to be sure\n" +
                "there isn't anything embarrassing.","2 hours ago"))

        var adapter=notificationRvAdapter(notifications)
        binding.rv.adapter=adapter
        binding.rv.layoutManager=LinearLayoutManager(activity)
    }


}