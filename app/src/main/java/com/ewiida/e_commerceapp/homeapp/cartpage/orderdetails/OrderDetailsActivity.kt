package com.ewiida.e_commerceapp.homeapp.cartpage.orderdetails

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.ActivityOrderDetailsBinding
import com.ewiida.e_commerceapp.homeapp.homepage.trackpage.OrderTrackingActivity

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
            OrderDetailsItem("On Ear Headphone", "Beats Solo3 Wireless", "$50.00", R.drawable.head_sets)
        )

        val adapter = OrderDetailsAdapter(list)
        val layoutManager = LinearLayoutManager(this)
        binding.orderRecycler.adapter = adapter
        binding.orderRecycler.layoutManager = layoutManager


        binding.backButton.setOnClickListener {
            super.onBackPressed()
        }

        binding.placeOrderButton.setOnClickListener {
            val dialog=Dialog(this)
            dialog.setContentView(R.layout.successful_alert_dialog)
            dialog.window!!.setBackgroundDrawableResource(R.drawable._50_white_rect)
            dialog.window?.findViewById<Button>(R.id.trackOrder)?.setOnClickListener {
                val intent=Intent(this, OrderTrackingActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            dialog.show()
        }
    }
}