package com.ewiida.e_commerceapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.view.View
import com.ewiida.e_commerceapp.homeapp.HomeActivity
import com.ewiida.e_commerceapp.loginscreens.LoginActivity
import com.ewiida.e_commerceapp.onboarding.OnboardingActivity

class MainActivity : AppCompatActivity() {

    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp= PreferenceManager.getDefaultSharedPreferences(this)
        hideBars()
        checkFirstTimeOpened()
    }

    fun hideBars(){
        window.decorView.apply {
            systemUiVisibility= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }

    fun checkFirstTimeOpened() {
        if (!sp.getBoolean("flag", false)) {
            Handler().postDelayed({
                var it = Intent(this, OnboardingActivity::class.java)
                startActivity(it)
                this?.finish()
            }, 1500)
            /*binding.constraintLayout1.setOnClickListener { view : View ->

                view.findNavController().navigate(R.id.action_splash1_to_onBoardingOne)
            }*/
        } else {
            if (!sp.getBoolean("flag2", false)) {
                Handler().postDelayed({
                    var it = Intent(this, LoginActivity::class.java)
                    startActivity(it)
                    this?.finish()
                }, 1500)
            } else {
                Handler().postDelayed({
                    var it = Intent(this, HomeActivity::class.java)
                    startActivity(it)
                    this?.finish()
                }, 1500)

            }
        }
    }
}