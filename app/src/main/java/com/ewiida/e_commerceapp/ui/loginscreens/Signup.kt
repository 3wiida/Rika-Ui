package com.ewiida.e_commerceapp.ui.loginscreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.RetrofitServices
import com.ewiida.e_commerceapp.databinding.FragmentSignupBinding
import com.ewiida.e_commerceapp.utils.sharedpreferences.prefKeys.USER_TOKEN
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Signup : Fragment() {

    lateinit var binding: FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)

        binding.signupBtn.setOnClickListener { view : View ->
            lifecycleScope.launch(Dispatchers.IO){
                var registerResponse=RetrofitServices.rServices.register(binding.phoneInput.text.toString(),
                    binding.nameInput.text.toString(),1,binding.passwordInput.text.toString(),
                    binding.passwordreInput.text.toString(),"123","123","android")

                withContext(Dispatchers.IO){
                    if(registerResponse.isSuccessful){
                        Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            view.findNavController().navigate(R.id.action_signup_to_successful)
        }

        binding.nameInput.addTextChangedListener {
            if(binding.nameInput.text.toString().length < 10){
                binding.nameInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            }else{
                binding.nameInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_circle_24, 0)
            }
        }

        binding.phoneInput.addTextChangedListener {
            if(binding.phoneInput.text.toString().length < 10){
                binding.phoneInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            }else{
                binding.phoneInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_circle_24, 0)
            }
        }

        return binding.root
    }
}