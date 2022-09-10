package com.ewiida.e_commerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ewiida.e_commerceapp.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {

    lateinit var binding : ActivityOrderDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backButton.setOnClickListener {
            super.onBackPressed()
        }
    }
}