package com.ewiida.e_commerceapp.homeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.homeapp.cartpage.CartPage
import com.ewiida.e_commerceapp.databinding.BottomNavigationBinding
import com.ewiida.e_commerceapp.homeapp.homepage.HomePage
import com.ewiida.e_commerceapp.homeapp.notificationspage.NotificationsPage
import com.ewiida.e_commerceapp.homeapp.profilepage.Profile

class HomeActivity : AppCompatActivity() {

    lateinit var binding : BottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = BottomNavigationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bottomNavigationBarController()
        hideBars()
        val intent = intent
        if(intent.getBooleanExtra("fromAddToCart",false)||intent.getBooleanExtra("FromProductCategory",false)){
            val cartPage=CartPage()
            replaceFragment(cartPage)
            binding.bottomNavigationView.menu.select(R.id.menuItemCart)
        }else{
            val homePage= HomePage()
            replaceFragment(homePage)
        }



    }

    private fun bottomNavigationBarController() {
        binding.bottomNavigationView.onItemSelectedListener={ view,menuItem,it->
            when(menuItem.id){
                R.id.menuItemHome->{
                    val f = HomePage()
                    replaceFragment(f)
                }
                R.id.menuItemCart->{
                    val f = CartPage()
                    replaceFragment(f)
                }
                R.id.menuItemNotifications->{
                    val f = NotificationsPage()
                    replaceFragment(f)
                }
                R.id.menuItemProfile->{
                    val f = Profile()
                    replaceFragment(f)
                }
            }

        }
    }


    private fun replaceFragment(f:Fragment){
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.container,f)
        ft.commit()
    }

    private fun hideBars(){
        window.decorView.apply {
            systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }
}