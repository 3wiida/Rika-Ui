package com.ewiida.e_commerceapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentOnBoardingThreeBinding

class OnBoardingThree : Fragment() {
    lateinit var binding: FragmentOnBoardingThreeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_on_boarding_three, container, false)

        return binding.root
    }
}