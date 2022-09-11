package com.ewiida.e_commerceapp.homeapp.homepage.productdetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ewiida.e_commerceapp.databinding.ActivityAddToCartBinding
import com.ewiida.e_commerceapp.homeapp.HomeActivity
import java.io.Serializable

class AddToCartActivity : AppCompatActivity(), Serializable {
    var bundle=Bundle()
    lateinit var binding:ActivityAddToCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddToCartBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val intent = intent
        binding.itemDes.text = intent.getStringExtra("productName")
        binding.backBtn.setOnClickListener {
            if(!intent.getBooleanExtra("FromWhere",false)){
                val intent2 = Intent(this,HomeActivity::class.java)
                startActivity(intent2)
                finish()
            }else{
                onBackPressed()
            }

        }
        binding.addToCartBtn.setOnClickListener {
            val intent3=Intent(this,HomeActivity::class.java)
            intent3.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent3.putExtra("fromAddToCart",true)
            startActivity(intent3)

        }

    }
}