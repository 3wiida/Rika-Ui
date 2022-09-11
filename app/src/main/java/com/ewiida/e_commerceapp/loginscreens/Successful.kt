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
import com.ewiida.e_commerceapp.homeapp.HomeActivity
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentSuccessfulBinding

class Successful : Fragment() {

    lateinit var binding: FragmentSuccessfulBinding
    private lateinit var sp: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_successful, container, false)

        binding.start.setOnClickListener { view : View ->
            val intent = Intent(activity, HomeActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
        sp = PreferenceManager.getDefaultSharedPreferences(activity)
        editor = sp.edit()
        editor.putBoolean("flag2",true)
        editor.commit()

        return binding.root
    }
}