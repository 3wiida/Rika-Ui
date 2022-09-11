package com.ewiida.e_commerceapp.homeapp.profilepage

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.ewiida.e_commerceapp.databinding.ActivitySettingsBinding
import com.ewiida.e_commerceapp.loginscreens.LoginActivity

class SettingsActivity : AppCompatActivity() {

    lateinit var binding : ActivitySettingsBinding
    private lateinit var sp: SharedPreferences
    private lateinit var editor:SharedPreferences.Editor


    @SuppressLint("SetTextI18n")
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