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
        var fm=supportFragmentManager
        var ft=fm.beginTransaction()
        var f=CategoriesFragment()
        ft.replace(R.id.MyNavHost,f)
        ft.commit()

    }
}