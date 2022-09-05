package com.ewiida.e_commerceapp.loginscreens

import android.content.SharedPreferences
import android.os.Bundle
import android.os.PerformanceHintManager
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentSplash2Binding

class Splash2 : Fragment() {
    lateinit var binding: FragmentSplash2Binding
    lateinit var sp:SharedPreferences
    lateinit var editor:SharedPreferences.Editor

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash2, container, false)

        binding.goToLoginBtn.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_splash2_to_login)
        }

        binding.goToSignupBtn.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_splash2_to_signup)
        }
        sp=PreferenceManager.getDefaultSharedPreferences(activity)
        editor=sp.edit()
        return binding.root




    }

    override fun onResume() {
        super.onResume()

        editor.putBoolean("flag",true)
        editor.commit()
    }


}