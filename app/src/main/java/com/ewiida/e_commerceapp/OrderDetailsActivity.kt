package com.ewiida.e_commerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewiida.e_commerceapp.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {

    lateinit var binding : ActivityOrderDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = listOf(
            OrderDetailsItem("Roller Rabbit", "Vado Odelle Dress", "$198.00", R.drawable.ongoing1),
            OrderDetailsItem("Axel Arigato", "Clean 90 Triole Sneakers", "$245.00", R.drawable.ongoing2),
            OrderDetailsItem("Herschel Supply Co.", "Daypack Backpack", "$40.00", R.drawable.ongoing3),
            OrderDetailsItem("On Ear Headphone", "Beats Solo3 Wireless", "$50.00", R.drawable.completed2)
        )

        val adapter = OrderDetailsAdapter(list)
        val layoutManager = LinearLayoutManager(this)
        binding.orderRecycler.adapter = adapter
        binding.orderRecycler.layoutManager = layoutManager


        binding.backButton.setOnClickListener {
            super.onBackPressed()
        }

        binding.placeOrderButton.setOnClickListener {
            //TODO Go to the prompt which mahmoud will do
        }
    }
}