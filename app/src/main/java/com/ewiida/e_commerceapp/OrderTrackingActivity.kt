package com.ewiida.e_commerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewiida.e_commerceapp.databinding.ActivityOrderTrackingBinding
import com.ewiida.e_commerceapp.homeapp.HomeActivity

class OrderTrackingActivity : AppCompatActivity() {

    lateinit var binding : ActivityOrderTrackingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderTrackingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val list = listOf(
            TrackingItem(R.drawable.ic_car_icon, "US 2343445668","Washington - Georgia", "Delivered"),
            TrackingItem(R.drawable.ic_car_icon, "US 2343445652", "Washington - llinois", "Transit"),
            TrackingItem(R.drawable.ic_car_icon, "US 2343445638","Franklin - Alabama", "Accepted")
        )

        val adapter = TrackingAdapter(list, this)
        val layoutManager = LinearLayoutManager(this)
        binding.trackingRecycler.adapter = adapter
        binding.trackingRecycler.layoutManager = layoutManager
        var itt=intent
        binding.backButton.setOnClickListener {
            if(itt.getBooleanExtra("fromOngoing",false)){
                onBackPressed()
            }else{
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }

        }

    }
}