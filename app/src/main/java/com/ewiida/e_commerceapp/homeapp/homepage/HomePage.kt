package com.ewiida.e_commerceapp.homeapp.homepage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.replace
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewiida.e_commerceapp.homeapp.homepage.categoriespages.CategoriesActivity
import com.ewiida.e_commerceapp.homeapp.homepage.trackpage.OrderTrackingActivity
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.homeapp.homepage.productdetails.AddToCartActivity
import com.ewiida.e_commerceapp.databinding.FragmentHomeBinding
import com.ewiida.e_commerceapp.homeapp.homepage.categoriespages.CategoryRvAdapter
import com.ewiida.e_commerceapp.homeapp.profilepage.Profile

class HomePage : Fragment() {

    var bundle:Bundle= Bundle()
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chipRecyclerViewHandler()
        itemsRecyclerViewHandler()

        binding.avatarBtn.setOnClickListener {
            var fm=activity?.supportFragmentManager
            var ft=fm?.beginTransaction()
            var profile=Profile()
            ft?.replace(R.id.container,profile)
            ft?.commit()
            var bottomNav=activity?.findViewById<github.com.st235.lib_expandablebottombar.ExpandableBottomBar>(R.id.bottomNavigationView)
            bottomNav?.menu?.select(R.id.menuItemProfile)
        }

        binding.viewall.setOnClickListener {
            var itt=Intent(activity,CategoriesActivity::class.java)
            itt.putExtra("cateName",binding.catename.text.toString())
            itt.putExtra("FromViewAll",true)
            startActivity(itt)
        }
    }


    @SuppressLint("SetTextI18n")
    private fun chipRecyclerViewHandler() {
        val categoryList = ArrayList<SubCategoryModel>()
        categoryList.add(SubCategoryModel("Dresses", true))
        categoryList.add(SubCategoryModel("Jackets"))
        categoryList.add(SubCategoryModel("Jeans"))
        categoryList.add(SubCategoryModel("Shoes"))
        categoryList.add(SubCategoryModel("Bags"))

        val rvAdapter = CategoryRvAdapter(requireContext(), categoryList)
        val lm = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.categoryRv.adapter = rvAdapter
        binding.categoryRv.layoutManager = lm
        binding.categoryRv.setHasFixedSize(true)

        rvAdapter.setOnCategoryClickedListener(object : CategoryRvAdapter.OnCategoryClicked {
            @SuppressLint("SetTextI18n")
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

    private fun itemsRecyclerViewHandler() {
        val items = ArrayList<ItemFromCategoryDataClass>()
        items.add(
            element = ItemFromCategoryDataClass(
                R.drawable.womanimage,
                "Roller Rabbit",
                "vado Odelle Dress",
                "\$198.00"
            )
        )
        items.add(
            element = ItemFromCategoryDataClass(
                R.drawable.manimage,
                "Endless Rose",
                "Bubble Elastic T-shirt",
                "\$50.00"
            )
        )
        items.add(
            element = ItemFromCategoryDataClass(
                R.drawable.manimage,
                "Endless Rose",
                "Bubble Elastic T-shirt",
                "\$50.00"
            )
        )
        items.add(
            element = ItemFromCategoryDataClass(
                R.drawable.womanimage,
                "Roller Rabbit",
                "vado Odelle Dress",
                "\$198.00"
            )
        )


        val itemAdapter = ItemFromCategoryRv(items)
        binding.itemsRv.layoutManager = GridLayoutManager(activity, 2)
        binding.itemsRv.adapter = itemAdapter

        itemAdapter.setOnItemSelected(object : ItemFromCategoryRv.OnItemSelected {
            override fun onItemClicked(position: Int) {
                Toast.makeText(activity, "fuck", Toast.LENGTH_SHORT).show()
            }
        })

        binding.categoryViewAll.setOnClickListener {
            val intent = Intent(activity, CategoriesActivity::class.java)
            startActivity(intent)
        }

        itemAdapter.setOnItemSelected(object :ItemFromCategoryRv.OnItemSelected{
            override fun onItemClicked(position: Int) {
                val intent = Intent(activity, AddToCartActivity::class.java)
                intent.putExtra("productName",items[position].itemName)
                startActivity(intent)
                activity?.finish()
            }
        })

        binding.cardView.setOnClickListener {
            val intent = Intent(activity, OrderTrackingActivity::class.java)
            startActivity(intent)
        }
        binding.imageButton3.setOnClickListener {
            val intent = Intent(activity, OrderTrackingActivity::class.java)
            startActivity(intent)
        }
    }
}