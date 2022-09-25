package com.ewiida.e_commerceapp.ui.homeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.BottomNavigationBinding
import github.com.st235.lib_expandablebottombar.navigation.ExpandableBottomBarNavigationUI

class HomeActivity : AppCompatActivity() {

    lateinit var binding : BottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navController: NavController =
            Navigation.findNavController(this, R.id.container)
        ExpandableBottomBarNavigationUI.setupWithNavController(binding.bottomNavigationView, navController)

    }

}