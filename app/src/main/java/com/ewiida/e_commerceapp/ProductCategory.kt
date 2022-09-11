package com.ewiida.e_commerceapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.ewiida.e_commerceapp.databinding.FragmentProductCategoryBinding
import com.ewiida.e_commerceapp.homeapp.homepage.itemFromCategoryDataClass


class ProductCategory : Fragment() {

    var bundle:Bundle?=null
    lateinit var binding:FragmentProductCategoryBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_category, container, false)
        bundle=arguments
        binding.categoryName.text=bundle?.getString("categoryName")

        binding.backButton.setOnClickListener {
            var fm=activity?.supportFragmentManager
            var ft=fm?.beginTransaction()
            var f=CategoriesFragment()
            ft?.replace(R.id.MyNavHost,f)
            ft?.commit()
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvHandler()
    }

    fun rvHandler(){
        var items = ArrayList<itemFromCategoryDataClass>()
        items.add(
           itemFromCategoryDataClass(
                R.drawable.womanimage,
                "Roller Rabbit",
                "vado Odelle Dress",
                "\$198.00"
            )
        )
        items.add(
            itemFromCategoryDataClass(
                R.drawable.manimage,
                "Endless Rose",
                "Bubble Elastic T-shirt",
                "\$50.00"
            )
        )
        items.add(
            itemFromCategoryDataClass(
                R.drawable.manimage,
                "Endless Rose",
                "Bubble Elastic T-shirt",
                "\$50.00"
            )
        )
        items.add(
             itemFromCategoryDataClass(
                R.drawable.womanimage,
                "Roller Rabbit",
                "vado Odelle Dress",
                "\$198.00"
            )
        )
        items.add(
            itemFromCategoryDataClass(
                R.drawable.womanimage,
                "Roller Rabbit",
                "vado Odelle Dress",
                "\$198.00"
            )
        )
        items.add(
            itemFromCategoryDataClass(
                R.drawable.manimage,
                "Endless Rose",
                "Bubble Elastic T-shirt",
                "\$50.00"
            )
        )
        items.add(
            itemFromCategoryDataClass(
                R.drawable.manimage,
                "Endless Rose",
                "Bubble Elastic T-shirt",
                "\$50.00"
            )
        )
        items.add(
            itemFromCategoryDataClass(
                R.drawable.womanimage,
                "Roller Rabbit",
                "vado Odelle Dress",
                "\$198.00"
            )
        )

        var adpter= ProductCategoryRvAdapter(items)


        binding.productRv.layoutManager=GridLayoutManager(requireContext(),2)
        binding.productRv.adapter=adpter


        adpter.onItemClicked = {
            var it=Intent(activity,addToCartActivity::class.java)
            it.putExtra("FromWhere",true)
            startActivity(it)
        }

        binding
    }
}