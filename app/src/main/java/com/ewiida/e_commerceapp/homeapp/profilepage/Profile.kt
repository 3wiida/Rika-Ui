package com.ewiida.e_commerceapp.homeapp.profilepage

import android.content.Intent
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
import com.ewiida.e_commerceapp.homeapp.profilepage.myorderspage.OngoingActivity
import com.ewiida.e_commerceapp.homeapp.homepage.HomePage

class Profile : Fragment() {

    lateinit var binding : FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        val list1 : List<ProfileItem> = listOf(
            ProfileItem("Personal Details", R.drawable.personal_details),
            ProfileItem("My Order", R.drawable.my_orders),
            ProfileItem("My Favourites", R.drawable.my_favourites),
            ProfileItem("Shipping Address", R.drawable.shipping_address),
            ProfileItem("My Card", R.drawable.my_card),
            ProfileItem("Settings", R.drawable.settings_black_fill)
        )

        val list2 : List<ProfileItem> = listOf(
            ProfileItem("FAQs", R.drawable.faqs),
            ProfileItem("Privacy Policy", R.drawable.privacy_policy),
            ProfileItem("Community", R.drawable.community)
        )

        val adapter1 = ProfileAdapter(list1)
        val adapter2 = ProfileAdapter(list2)
        val layoutManager1 = LinearLayoutManager(context)
        val layoutManager2 = LinearLayoutManager(context)

        binding.firstGroupRecycler.layoutManager = layoutManager1
        binding.firstGroupRecycler.adapter = adapter1
        binding.firstGroupRecycler.hasFixedSize()

        adapter1.onItemClicked = {
            when (it.name) {
                "My Order" -> {
                    val intent = Intent(activity, OngoingActivity::class.java)
                    startActivity(intent)
                }
                "Settings" -> {
                    val intent = Intent(activity, SettingsActivity::class.java)
                    startActivity(intent)
                }
                else -> {
                    Toast.makeText(activity, "There is no screen for this item!!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.backButton.setOnClickListener{
            val f = HomePage()
            val fm = activity?.supportFragmentManager
            val ft = fm?.beginTransaction()
            ft?.replace(R.id.container,f)
            ft?.commit()
            val bnb = activity?.findViewById<github.com.st235.lib_expandablebottombar.ExpandableBottomBar>(R.id.bottomNavigationView)
            bnb?.menu?.select(R.id.menuItemHome)
        }

        binding.settingsButton.setOnClickListener {
            var itt=Intent(activity,SettingsActivity::class.java)
            startActivity(itt)
        }

        binding.secondGroupRecycler.layoutManager = layoutManager2
        binding.secondGroupRecycler.adapter = adapter2
        binding.secondGroupRecycler.hasFixedSize()

        adapter2.onItemClicked = {
                Toast.makeText(activity, "There is no screen for this item!!", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }



}