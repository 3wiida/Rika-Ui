package com.ewiida.e_commerceapp.homeapp.homepage.categoriespages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.ActivityCategoriesBinding

class CategoriesActivity : AppCompatActivity() {

    lateinit var binding: ActivityCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        val f = CategoriesFragment()
        ft.replace(R.id.MyNavHost, f)
        ft.commit()

    }
}