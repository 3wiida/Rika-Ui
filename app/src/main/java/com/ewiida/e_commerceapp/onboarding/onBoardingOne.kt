package com.ewiida.e_commerceapp.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentOnBoardingOneBinding

class onBoardingOne : Fragment() {

    lateinit var binding: FragmentOnBoardingOneBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_on_boarding_one, container, false)

        return binding.root
    }
}