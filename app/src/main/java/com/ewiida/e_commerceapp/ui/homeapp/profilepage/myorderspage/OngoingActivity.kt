package com.ewiida.e_commerceapp.ui.homeapp.profilepage.myorderspage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewiida.e_commerceapp.ui.homeapp.homepage.trackpage.OrderTrackingActivity
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.ActivityOngoingBinding

class OngoingActivity : AppCompatActivity() {

    lateinit var binding : ActivityOngoingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOngoingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = ArrayList<Order>()
        list.add(Order(R.drawable.ongoing1, "Roller Rabbit", "Vado Odelle Dress", "1", "L", "$198.00"))
        list.add(Order(R.drawable.ongoing2, "Axel Arigato", "Clean 90 Triole Sneakers", "2", "41", "$245.00"))
        list.add(Order(R.drawable.ongoing3, "Herschel Supply Co.", "Daypack Backpack", "10", "M", "$40.00"))

        var adapter = MyOrdersAdapter(list)
        val layoutManager = LinearLayoutManager(this)
        binding.myOrdersRecycler.adapter = adapter
        binding.myOrdersRecycler.layoutManager = layoutManager

        adapter.onItemClicked = {
            val intent = Intent(this, OrderTrackingActivity::class.java)
            intent.putExtra("fromOngoing",true)
            startActivity(intent)
        }

        binding.radioGroup.setOnCheckedChangeListener{radioGroup, ID->
            if(ID == R.id.ongoingRadio){
                list.clear()
                list.add(Order(R.drawable.ongoing1, "Roller Rabbit", "Vado Odelle Dress", "1", "L", "$198.00"))
                list.add(Order(R.drawable.ongoing2, "Axel Arigato", "Clean 90 Triole Sneakers", "2", "41", "$245.00"))
                list.add(Order(R.drawable.ongoing3, "Herschel Supply Co.", "Daypack Backpack", "10", "M", "$40.00"))

                adapter = MyOrdersAdapter(list)
                binding.myOrdersRecycler.adapter = adapter

                adapter.onItemClicked = {
                    val intent = Intent(this, OrderTrackingActivity::class.java)
                    intent.putExtra("fromOngoing",true)
                    startActivity(intent)
                }
            }
            else if(ID == R.id.completedRadio){
                list.clear()
                list.add(Order(R.drawable.completed1, "Soludos", "Ibiza Classic Lace Sneakers", "5", "45", "$120.00"))
                list.add(Order(R.drawable.head_sets, "On Ear Headphone", "Beats Solo3 Wireless Kulak", "8", "XL", "$50.00"))
                adapter = MyOrdersAdapter(list)
                binding.myOrdersRecycler.adapter = adapter

                adapter.onItemClicked = {
                    val intent = Intent(this, OrderTrackingActivity::class.java)
                    intent.putExtra("fromOngoing",true)
                    startActivity(intent)
                }
            }
        }

        binding.backButton.setOnClickListener {
            super.onBackPressed()
        }

        hideBars()
    }

    private fun hideBars(){
        window.decorView.apply {
            systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }
}