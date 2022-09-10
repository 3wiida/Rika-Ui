package com.ewiida.e_commerceapp.homeapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Toast
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.ActivitySettingsBinding
import com.ewiida.e_commerceapp.loginscreens.LoginActivity
import com.ewiida.e_commerceapp.loginscreens.Splash2
import com.ewiida.e_commerceapp.onboarding.OnboardingActivity

class SettingsActivity : AppCompatActivity() {

    lateinit var binding : ActivitySettingsBinding
    lateinit var sp: SharedPreferences
    lateinit var editor:SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp= PreferenceManager.getDefaultSharedPreferences(this)
        editor=sp.edit()

        binding.backButton2.setOnClickListener {
            super.onBackPressed()
        }

        binding.logoutButton.setOnClickListener {
            editor.clear()
            editor.putBoolean("flag", true)
            editor.commit()
            val i = Intent(this, LoginActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
        }

        binding.darkModeSwitch.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
                binding.darkModeStateText.text = "on"
            }else{
                binding.darkModeStateText.text = "off"
            }
        }
        
        binding.notificationsSwitch.setOnCheckedChangeListener{ compoundButton, b ->
            if(b){
                binding.notificationsStateText.text = "on"
            }else{
                binding.notificationsStateText.text = "off"
            }
        }
    }


}