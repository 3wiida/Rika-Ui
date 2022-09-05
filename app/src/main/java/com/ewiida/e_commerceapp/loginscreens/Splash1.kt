package com.ewiida.e_commerceapp.loginscreens

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.ewiida.e_commerceapp.Activity2
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentSplash1Binding

class Splash1 : Fragment() {
    lateinit var binding: FragmentSplash1Binding
    lateinit var sp: SharedPreferences
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash1, container, false)
        sp=PreferenceManager.getDefaultSharedPreferences(activity)

        checkFirstTimeOpened()

        return binding.root
    }
    fun checkFirstTimeOpened(){
        if(!sp.getBoolean("flag",false)){
            Handler().postDelayed({ view?.findNavController()?.navigate(R.id.action_splash1_to_onBoardingOne)}, 1500)
            /*binding.constraintLayout1.setOnClickListener { view : View ->

                view.findNavController().navigate(R.id.action_splash1_to_onBoardingOne)
            }*/
        }else{
            if(!sp.getBoolean("flag2",false)){
                Handler().postDelayed({ view?.findNavController()?.navigate(R.id.action_splash1_to_splash2)}, 1500)
            }else{
                Handler().postDelayed({ var it=Intent(activity,Activity2::class.java)
                                      startActivity(it)
                                        activity?.finish()
                                      }, 1500)

        }
    }


    }
}