package com.ewiida.e_commerceapp.ui.homeapp.notificationspage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentNotificationsBinding


class NotificationsPage : Fragment() {

    lateinit var binding : FragmentNotificationsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notifications, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notificationRecyclerViewHandler()
        Log.d("tag","test")
        binding.backBtn.setOnClickListener{
            findNavController().popBackStack()
        }
    }


    private fun notificationRecyclerViewHandler(){
        val notifications=ArrayList<NotificationDataClass>()
        notifications.add(element = NotificationDataClass(R.drawable.manimage, "Mahmoud ewida","It is a long established fact\n" +
                "that a reader will be distracted by the\n" +
                "readable content of a page","2 hours ago"))
        notifications.add(element = NotificationDataClass(R.drawable.womanimage, "Abd El-Halem","There are many variations of \n" +
                "passages of Lorem Ipsum available.","2 hours ago"))
        notifications.add(element = NotificationDataClass(R.drawable.manimage, "Yousef Hassan"," If you are going to use a\n" +
                "passage of Lorem Ipsum, you need to be sure\n" +
                "there isn't anything embarrassing.","2 hours ago"))
        notifications.add(element = NotificationDataClass(R.drawable.manimage, "Mahmoud ewida","It is a long established fact\n" +
                "that a reader will be distracted by the\n" +
                "readable content of a page","2 hours ago"))
        notifications.add(element = NotificationDataClass(R.drawable.womanimage, "Abd El-Halem","There are many variations of \n" +
                "passages of Lorem Ipsum available.","2 hours ago"))
        notifications.add(element = NotificationDataClass(R.drawable.manimage, "Yousef Hassan"," If you are going to use a\n" +
                "passage of Lorem Ipsum, you need to be sure\n" +
                "there isn't anything embarrassing.","2 hours ago"))
        notifications.add(element = NotificationDataClass(R.drawable.manimage, "Mahmoud ewida","It is a long established fact\n" +
                "that a reader will be distracted by the\n" +
                "readable content of a page","2 hours ago"))
        notifications.add(element = NotificationDataClass(R.drawable.womanimage, "Abd El-Halem","There are many variations of \n" +
                "passages of Lorem Ipsum available.","2 hours ago"))
        notifications.add(element = NotificationDataClass(R.drawable.manimage, "Yousef Hassan"," If you are going to use a\n" +
                "passage of Lorem Ipsum, you need to be sure\n" +
                "there isn't anything embarrassing.","2 hours ago"))
        notifications.add(element = NotificationDataClass(R.drawable.manimage, "Mahmoud ewida","It is a long established fact\n" +
                "that a reader will be distracted by the\n" +
                "readable content of a page","2 hours ago"))
        notifications.add(element = NotificationDataClass(R.drawable.womanimage, "Abd El-Halem","There are many variations of \n" +
                "passages of Lorem Ipsum available.","2 hours ago"))
        notifications.add(element = NotificationDataClass(R.drawable.manimage, "Yousef Hassan"," If you are going to use a\n" +
                "passage of Lorem Ipsum, you need to be sure\n" +
                "there isn't anything embarrassing.","2 hours ago"))

        val adapter=NotificationRvAdapter(notifications)
        binding.rv.adapter=adapter
        binding.rv.layoutManager=LinearLayoutManager(activity)
    }


}