package com.ewiida.e_commerceapp.homeapp.homepage.categoriespages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.replace
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
        val itt=intent
        val flag=itt.getBooleanExtra("FromViewAll",false)

        if(flag){
            val pc=ProductCategory()
            val bundle=Bundle()
            bundle.putBoolean("flag",true)
            bundle.putString("cateName",itt.getStringExtra("cateName"))
            pc.arguments=bundle
            ft.replace(R.id.MyNavHost,pc)
            ft.commit()
        }else{
            ft.replace(R.id.MyNavHost, f)
            ft.commit()
        }

        hideBars()
    }

    private fun hideBars(){
        window.decorView.apply {
            systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }
}