package com.ewiida.e_commerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import com.ewiida.e_commerceapp.databinding.ActivityAddToCartBinding
import com.ewiida.e_commerceapp.homeapp.homepage.itemFromCategoryDataClass
import java.io.Serializable

class addToCartActivity : AppCompatActivity(), Serializable {
    var bundle=Bundle()
    lateinit var binding:ActivityAddToCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddToCartBinding.inflate(layoutInflater)

        setContentView(binding.root)
        var it=intent
        binding.itemDes.text=it.getStringExtra("productName")

    }
}