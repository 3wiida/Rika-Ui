package com.ewiida.e_commerceapp.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentOnBoardingOneBinding
import com.ewiida.e_commerceapp.databinding.FragmentOnBoardingThreeBinding
import com.ewiida.e_commerceapp.loginscreens.LoginActivity

class onBoardingThree : Fragment() {
    lateinit var binding: FragmentOnBoardingThreeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_on_boarding_three, container, false)

//        binding.floatingActionButton.setOnClickListener { view : View ->
//            var it:Intent= Intent(activity, LoginActivity::class.java)
//            startActivity(it)
//            activity?.finish()
//        }

        return binding.root
    }
}