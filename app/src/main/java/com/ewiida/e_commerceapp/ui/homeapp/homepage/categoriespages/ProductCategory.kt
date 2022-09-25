package com.ewiida.e_commerceapp.ui.homeapp.homepage.categoriespages

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentProductCategoryBinding
import com.ewiida.e_commerceapp.ui.homeapp.homepage.ItemFromCategoryDataClass
import com.ewiida.e_commerceapp.ui.homeapp.homepage.productdetails.AddToCartActivity


class ProductCategory : Fragment() {

    var bundle:Bundle?=null
    lateinit var binding:FragmentProductCategoryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_product_category, container, false)
        bundle=arguments
        if(bundle!!.getBoolean("flag")){
            var s=bundle?.getString("cateName")
            s=s?.slice(3 until s.length)
            binding.categoryName.text=s
        }else{
            binding.categoryName.text=bundle?.getString("categoryName")
        }


        binding.backButton.setOnClickListener {
            val fm = activity?.supportFragmentManager
            val ft = fm?.beginTransaction()
            val f = CategoriesFragment()
            ft?.replace(R.id.MyNavHost,f)
            ft?.commit()
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvHandler()
    }

    private fun rvHandler(){
        val items = ArrayList<ItemFromCategoryDataClass>()
        items.add(
           ItemFromCategoryDataClass(
               R.drawable.womanimage,
                "Roller Rabbit",
                "vado Odelle Dress",
                "\$198.00"
            )
        )
        items.add(
            ItemFromCategoryDataClass(
                R.drawable.manimage,
                "Endless Rose",
                "Bubble Elastic T-shirt",
                "\$50.00"
            )
        )
        items.add(
            ItemFromCategoryDataClass(
                R.drawable.manimage,
                "Endless Rose",
                "Bubble Elastic T-shirt",
                "\$50.00"
            )
        )
        items.add(
             ItemFromCategoryDataClass(
                 R.drawable.womanimage,
                "Roller Rabbit",
                "vado Odelle Dress",
                "\$198.00"
            )
        )
        items.add(
            ItemFromCategoryDataClass(
                R.drawable.womanimage,
                "Roller Rabbit",
                "vado Odelle Dress",
                "\$198.00"
            )
        )
        items.add(
            ItemFromCategoryDataClass(
                R.drawable.manimage,
                "Endless Rose",
                "Bubble Elastic T-shirt",
                "\$50.00"
            )
        )
        items.add(
            ItemFromCategoryDataClass(
                R.drawable.manimage,
                "Endless Rose",
                "Bubble Elastic T-shirt",
                "\$50.00"
            )
        )
        items.add(
            ItemFromCategoryDataClass(
                R.drawable.womanimage,
                "Roller Rabbit",
                "vado Odelle Dress",
                "\$198.00"
            )
        )

        val adapter = ProductCategoryRvAdapter(items)


        binding.productRv.layoutManager=GridLayoutManager(requireContext(),2)
        binding.productRv.adapter=adapter


        adapter.onItemClicked = {
            val intent=Intent(activity, AddToCartActivity::class.java)
            intent.putExtra("FromWhere",true)
            startActivity(intent)
        }

        binding
    }
}