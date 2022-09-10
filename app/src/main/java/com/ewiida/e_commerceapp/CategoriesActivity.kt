package com.ewiida.e_commerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.databinding.ActivityCategoriesBinding

class CategoriesActivity : AppCompatActivity() {

    lateinit var binding: ActivityCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = listOf<CategoryItem>(
            CategoryItem("New Arrivals", "208 Products", R.drawable.categorie_new_arrivals),
            CategoryItem("Clothes", "358 Products", R.drawable.categorie_clothes),
            CategoryItem("Bags", "160 Products", R.drawable.categorie_bags),
            CategoryItem("Shoes", "230 Products", R.drawable.categorie_shoes),
            CategoryItem("Electronics", "130 Products", R.drawable.categorie_electronics)
        )

        val adapter = CategoryAdapter(list)
        val layoutManager = LinearLayoutManager(this)

        binding.categoriesRecycler.adapter = adapter
        binding.categoriesRecycler.layoutManager = layoutManager

    }
}