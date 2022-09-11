package com.ewiida.e_commerceapp.homeapp.homepage.categoriespages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {

    lateinit var binding : FragmentCategoriesBinding
    var bundle=Bundle()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false)

        val list = listOf(
            CategoryItem("New Arrivals", "208 Products", R.drawable.categorie_new_arrivals),
            CategoryItem("Clothes", "358 Products", R.drawable.categorie_clothes),
            CategoryItem("Bags", "160 Products", R.drawable.categorie_bags),
            CategoryItem("Shoes", "230 Products", R.drawable.categorie_shoes),
            CategoryItem("Electronics", "130 Products", R.drawable.categorie_electronics)
        )

        val adapter = CategoryAdapter(list)
        val layoutManager = LinearLayoutManager(activity)

        binding.categoriesRecycler.adapter = adapter
        binding.categoriesRecycler.layoutManager = layoutManager
        val fm = activity?.supportFragmentManager

        adapter.onItemClicked = {
            when (it.name) {
                "New Arrivals" -> {
                    val f = ProductCategory()
                    bundle.putString("categoryName","New Arrivals")
                    f.arguments=bundle
                    val ft = fm?.beginTransaction()
                    ft?.replace(R.id.MyNavHost,f)
                    ft?.commit()
                }
                "Clothes" -> {
                    val ft = fm?.beginTransaction()
                    val f = ProductCategory()
                    bundle.putString("categoryName","Clothes")
                    f.arguments=bundle
                    ft?.replace(R.id.MyNavHost,f)
                    ft?.commit()
                }
                "Bags" -> {
                    val ft = fm?.beginTransaction()
                    val f = ProductCategory()
                    bundle.putString("categoryName","Bags")
                    f.arguments=bundle
                    ft?.replace(R.id.MyNavHost,f)
                    ft?.commit()
                }
                "Shoes" -> {
                    val ft = fm?.beginTransaction()
                    val f = ProductCategory()
                    bundle.putString("categoryName","Shoes")
                    f.arguments=bundle
                    ft?.replace(R.id.MyNavHost,f)
                    ft?.commit()
                }
                else -> {
                    val ft = fm?.beginTransaction()
                    val f = ProductCategory()
                    bundle.putString("categoryName","Electronics")
                    f.arguments=bundle
                    ft?.replace(R.id.MyNavHost,f)
                    ft?.commit()
                }
            }
        }

        binding.backButton3.setOnClickListener {
            activity?.onBackPressed()
        }


        return binding.root
    }
}