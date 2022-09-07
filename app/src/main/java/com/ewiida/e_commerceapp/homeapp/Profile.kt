package com.ewiida.e_commerceapp.homeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentProfileBinding

class Profile : Fragment() {

    lateinit var binding : FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        val list1 : List<ProfileItem> = listOf(
            ProfileItem("Personal Details", R.drawable.personal_details),
            ProfileItem("My Order", R.drawable.my_orders),
            ProfileItem("My Favourites", R.drawable.my_favourites),
            ProfileItem("Shipping Address", R.drawable.shipping_address),
            ProfileItem("My Card", R.drawable.my_card),
            ProfileItem("Settings", R.drawable.settings_black_fill))

        val list2 : List<ProfileItem> = listOf(
            ProfileItem("FAQs", R.drawable.faqs),
            ProfileItem("Privacy Policy", R.drawable.privacy_policy),
            ProfileItem("Community", R.drawable.community))

        val adapter1 = ProfileAdapter(list1)
        val adapter2 = ProfileAdapter(list2)
        val layoutManager1 = LinearLayoutManager(context)
        val layoutManager2 = LinearLayoutManager(context)

        binding.firstGroupRecycler.layoutManager = layoutManager1
        binding.firstGroupRecycler.adapter = adapter1
        binding.firstGroupRecycler.hasFixedSize()

        binding.secondGroupRecycler.layoutManager = layoutManager2
        binding.secondGroupRecycler.adapter = adapter2
        binding.secondGroupRecycler.hasFixedSize()




        return binding.root
    }

}