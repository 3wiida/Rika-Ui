package com.ewiida.e_commerceapp.loginscreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentLoginBinding


class login : Fragment() {
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.loginBtn.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_login_to_successful)
        }

        return binding.root
    }
}