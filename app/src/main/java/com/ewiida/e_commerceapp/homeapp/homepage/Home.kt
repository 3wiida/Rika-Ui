package com.ewiida.e_commerceapp.homeapp.homepage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.CategoriesActivity
import com.ewiida.e_commerceapp.OrderTrackingActivity
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.addToCartActivity
import com.ewiida.e_commerceapp.databinding.FragmentHomeBinding


class Home : Fragment() {
    var bundle:Bundle= Bundle()
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chipRecyclerViewHandler()
        itemsRecyclerViewHandler()



    }


    fun chipRecyclerViewHandler() {
        var categoryList = ArrayList<SubCategoryModel>()
        categoryList.add(SubCategoryModel("Dresses", true))
        categoryList.add(SubCategoryModel("Jackets"))
        categoryList.add(SubCategoryModel("Jeans"))
        categoryList.add(SubCategoryModel("Shoes"))
        categoryList.add(SubCategoryModel("Bags"))
        //categoryList.add(SubCategoryModel("New Arrivals"))
        //categoryList.add(SubCategoryModel("Electronics"))

        var rvAdapter = category_rv_adapter(requireContext(), categoryList)
        var lm = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.categoryRv.adapter = rvAdapter

        binding.categoryRv.layoutManager = lm
        binding.categoryRv.setHasFixedSize(true)
        rvAdapter.setOnCategoryClickedListener(object : category_rv_adapter.onCategoryClicked {
            override fun onClick(pos: Int) {
                binding.catename.text = "Top ${categoryList[pos]}"
            }

        })
        rvAdapter.onClickListener = { adapterItem ->
            categoryList.forEach { listItem ->
                listItem.selected = listItem.name ==adapterItem.name
            }
            rvAdapter.setList(categoryList)
            binding.catename.text = "Top ${adapterItem.name}"
        }
    }

    fun itemsRecyclerViewHandler() {
        var items = ArrayList<itemFromCategoryDataClass>()
        items.add(
            element = itemFromCategoryDataClass(
                R.drawable.womanimage,
                "Roller Rabbit",
                "vado Odelle Dress",
                "\$198.00"
            )
        )
        items.add(
            element = itemFromCategoryDataClass(
                R.drawable.manimage,
                "Endless Rose",
                "Bubble Elastic T-shirt",
                "\$50.00"
            )
        )
        items.add(
            element = itemFromCategoryDataClass(
                R.drawable.manimage,
                "Endless Rose",
                "Bubble Elastic T-shirt",
                "\$50.00"
            )
        )
        items.add(
            element = itemFromCategoryDataClass(
                R.drawable.womanimage,
                "Roller Rabbit",
                "vado Odelle Dress",
                "\$198.00"
            )
        )


        var itemAdapter = item_fromCategory_rv(items)
        binding.itemsRv.layoutManager = GridLayoutManager(activity, 2)
        binding.itemsRv.adapter = itemAdapter

        itemAdapter.setOnItemSelected(object : item_fromCategory_rv.onItemSelected {
            override fun onItemClicked(position: Int) {
                Toast.makeText(activity, "fuck", Toast.LENGTH_SHORT).show()
            }

        })

        binding.categoryViewAll.setOnClickListener {
            val intent = Intent(activity, CategoriesActivity::class.java)
            startActivity(intent)
        }
        itemAdapter.setOnItemSelected(object :item_fromCategory_rv.onItemSelected{
            override fun onItemClicked(position: Int) {
                var it=Intent(activity,addToCartActivity::class.java)
                it.putExtra("productName",items[position].itemName)
                startActivity(it)
                activity?.finish()
            }

        })

        binding.cardView.setOnClickListener {
            var intent = Intent(activity, OrderTrackingActivity::class.java)
            startActivity(intent)
        }
        binding.imageButton3.setOnClickListener {
            var intent = Intent(activity, OrderTrackingActivity::class.java)
            startActivity(intent)
        }
    }
}