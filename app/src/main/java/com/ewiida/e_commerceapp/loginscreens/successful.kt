package com.ewiida.e_commerceapp.loginscreens

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.ewiida.e_commerceapp.Activity2
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentSuccessfulBinding

class successful : Fragment() {
    lateinit var binding: FragmentSuccessfulBinding
    lateinit var sp: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_successful, container, false)

        binding.start.setOnClickListener { view : View ->
            var it:Intent=Intent(activity,Activity2::class.java)
            startActivity(it)
            activity?.finish()
        }
        sp=PreferenceManager.getDefaultSharedPreferences(activity)
        editor=sp.edit()
        editor.putBoolean("flag2",true)
        editor.commit()
        return binding.root
    }
}