package com.ewiida.e_commerceapp.homeapp.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentHomeBinding


class Home : Fragment() {

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        return return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var categoryList=ArrayList<String>()
        categoryList.add("Dresses")
        categoryList.add("Jackets")
        categoryList.add("Jeans")
        categoryList.add("Shoese")
        categoryList.add("New Arrivals")
        categoryList.add("Bags")
        categoryList.add("Shoese")
        categoryList.add("Electronics")

        var rvAdapter=category_rv_adapter(categoryList)
        var lm=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        binding.categoryRv.adapter=rvAdapter
        binding.categoryRv.layoutManager=lm
        binding.categoryRv.setHasFixedSize(true)

    }


}