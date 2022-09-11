package com.ewiida.e_commerceapp.homeapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ewiida.e_commerceapp.ProductCategory
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.homeapp.cartpage.Cart
import com.ewiida.e_commerceapp.databinding.Activity2Binding
import com.ewiida.e_commerceapp.homeapp.homepage.Home
import com.ewiida.e_commerceapp.homeapp.notificationspage.Notifications

class HomeActivity : AppCompatActivity() {
    lateinit var binding : Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = Activity2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        BottomNavigationBarControler()
        hideBars()
        var itt=intent
        if(itt.getBooleanExtra("fromAddToCart",false)){
            var cart=Cart()
            replaceFragment(cart)
            binding.bottomNavigationView.menu.select(R.id.menuItemCart)
        }else{
            var home= Home()
            replaceFragment(home)
        }

    }

    private fun BottomNavigationBarControler() {
        binding.bottomNavigationView.onItemSelectedListener={ view,menuItem,it->
            when(menuItem.id){
                R.id.menuItemHome->{
                    var f=Home()
                    replaceFragment(f)
                }
                R.id.menuItemCart->{
                    var f= Cart()
                    replaceFragment(f)
                }
                R.id.menuItemNotifications->{
                    var f= Notifications()
                    replaceFragment(f)
                }
                R.id.menuItemProfile->{
                    var f=Profile()
                    replaceFragment(f)
                }
            }

        }
    }


    private fun replaceFragment(f:Fragment){
        var fm=supportFragmentManager
        var ft=fm.beginTransaction()
        ft.replace(R.id.container,f)
        ft.commit()
    }

    private fun hideBars(){
        window.decorView.apply {
            systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }
}