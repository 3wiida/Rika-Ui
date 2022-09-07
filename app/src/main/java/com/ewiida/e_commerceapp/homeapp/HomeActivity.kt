package com.ewiida.e_commerceapp.homeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.Activity2Binding
import com.ewiida.e_commerceapp.mainScreens.Home

class HomeActivity : AppCompatActivity() {
    lateinit var binding : Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = Activity2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var home=Home()
        replaceFragment(home)
       // BottomNavigationBarControler()
       // hideBars()

    }






    private fun replaceFragment(f:Fragment){
        var fm=supportFragmentManager
        var ft=fm.beginTransaction()
        ft.replace(R.id.container,f)
        ft.commit()
    }

    private fun hideBars(){
        window.decorView.apply {
            systemUiVisibility= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }
}