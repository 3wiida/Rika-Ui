package com.ewiida.e_commerceapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.view.View
import com.ewiida.e_commerceapp.ui.homeapp.HomeActivity
import com.ewiida.e_commerceapp.ui.loginscreens.LoginActivity
import com.ewiida.e_commerceapp.ui.onboarding.OnBoardingActivity

class MainActivity : AppCompatActivity() {

    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp = PreferenceManager.getDefaultSharedPreferences(this)
        hideBars()
        checkFirstTimeOpened()
    }

    private fun hideBars(){
        window.decorView.apply {
            systemUiVisibility= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }

    private fun checkFirstTimeOpened() {
        if (!sp.getBoolean("flag", false)) {
            Handler().postDelayed({
                val it = Intent(this, OnBoardingActivity::class.java)
                startActivity(it)
                this.finish()
            }, 1500)
        } else {
            if (!sp.getBoolean("flag2", false)) {
                Handler().postDelayed({
                    val it = Intent(this, LoginActivity::class.java)
                    startActivity(it)
                    this.finish()
                }, 1500)
            } else {
                Handler().postDelayed({
                    val it = Intent(this, HomeActivity::class.java)
                    startActivity(it)
                    this.finish()
                }, 1500)
            }
        }
    }
}