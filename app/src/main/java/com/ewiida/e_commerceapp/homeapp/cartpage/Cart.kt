package com.ewiida.e_commerceapp.homeapp.cartpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentCartBinding


class Cart : Fragment() {
    lateinit var binding:FragmentCartBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cart, container, false)
         return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var cartItems=ArrayList<cart_item_data_class>()
        cartItems.add(element = cart_item_data_class(R.drawable.womanimage,"Roller Rabbit","Vado Odelle Dress",198))
        cartItems.add(element = cart_item_data_class(R.drawable.cotchie,"Axel Arigato","Clean 90 Triole Snakers",245))
        cartItems.add(element = cart_item_data_class(R.drawable.backbag,"Herschel Supply Co.","Daypack Backpack",40))

        var cartItemAdapter=cart_items_rv_adabter(cartItems)
        binding.cartItemsRv.adapter=cartItemAdapter
        binding.cartItemsRv.layoutManager=LinearLayoutManager(activity)
    }


}