package com.ewiida.e_commerceapp.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentOnBoardingTwoBinding

class OnBoardingTwo : Fragment() {

    lateinit var binding: FragmentOnBoardingTwoBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_on_boarding_two, container, false)

        return binding.root
    }
}