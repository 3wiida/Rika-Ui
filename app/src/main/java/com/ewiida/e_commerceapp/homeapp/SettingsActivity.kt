package com.ewiida.e_commerceapp.homeapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
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

        //TODO Look at this
        binding.logoutButton.setOnClickListener {
            editor.clear()
            editor.putBoolean("flag", true)
            editor.commit()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            //Toast.makeText(this, "You logged out", Toast.LENGTH_SHORT).show()
            //super.onBackPressed()
        }
    }


}