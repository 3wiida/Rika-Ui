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
import com.ewiida.e_commerceapp.databinding.FragmentLoginBinding
import com.ewiida.e_commerceapp.utils.sharedpreferences.prefKeys.USER_TOKEN
import com.ewiida.e_commerceapp.utils.sharedpreferences.prefUtils.Companion.savePref
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class Login : Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.loginBtn.setOnClickListener { view : View ->
            lifecycleScope.launch(Dispatchers.IO){
                var user=RetrofitServices.rServices.login(binding.passwordInput.text.toString(),
                    binding.passwordInput.text.toString(),
                    "123","123","android")
                savePref(requireContext(),USER_TOKEN,user.access_token)

                withContext(Dispatchers.Main){
                    if(user.status=="success"){
                        view.findNavController().navigate(R.id.action_login_to_successful)
                        Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                    }
                }

            }


        }

        binding.passwordInput.addTextChangedListener {
            if(binding.passwordInput.text.toString().length < 10){
                binding.passwordInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            }else{
                binding.passwordInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_circle_24, 0)
            }
        }

        return binding.root
    }
}