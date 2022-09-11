package com.ewiida.e_commerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import com.ewiida.e_commerceapp.databinding.ActivityAddToCartBinding
import com.ewiida.e_commerceapp.homeapp.HomeActivity
import com.ewiida.e_commerceapp.homeapp.homepage.itemFromCategoryDataClass
import java.io.Serializable

class addToCartActivity : AppCompatActivity(), Serializable {
    var bundle=Bundle()
    lateinit var binding:ActivityAddToCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddToCartBinding.inflate(layoutInflater)

        setContentView(binding.root)
        var itt=intent
        binding.itemDes.text=itt.getStringExtra("productName")
        binding.backBtn.setOnClickListener {
            if(itt.getBooleanExtra("FromWhere",false).equals(false)){
                var it=Intent(this,HomeActivity::class.java)
                startActivity(it)
                finish()
            }else{
                onBackPressed()
            }

        }
        binding.addToCartBtn.setOnClickListener {
            var itt=Intent(this,HomeActivity::class.java)
            itt.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            itt.putExtra("fromAddToCart",true)
            startActivity(itt)

        }

    }
}