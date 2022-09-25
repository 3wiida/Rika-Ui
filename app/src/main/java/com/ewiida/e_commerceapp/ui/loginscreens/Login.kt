package com.ewiida.e_commerceapp.ui.loginscreens

import android.os.Bundle
import android.util.Log
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
import retrofit2.HttpException
import java.io.IOException


class Login : Fragment() {
    val TAG = "3wiida"
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.loginBtn.setOnClickListener { view: View ->
            lifecycleScope.launch(Dispatchers.IO) {

                try {
                    RetrofitServices.rServices.login(
                        binding.phoneInput.text.toString(),
                        binding.passwordInput.text.toString(),
                        "123", "123", "android"
                    )
                } catch (e: Exception) {
                    when (e) {
                        is HttpException -> {
                            Log.d(TAG, "onCreateView: " + e.response()?.errorBody()?.string())
                        }
                        is IOException -> {
                            Log.d(TAG, "onCreateView: " + e.localizedMessage)
                        }
                    }
                    Log.d(TAG, "onCreateView: ${e.message}")
                }


            }


        }

        binding.passwordInput.addTextChangedListener {
            if (binding.passwordInput.text.toString().length < 10) {
                binding.passwordInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            } else {
                binding.passwordInput.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_baseline_check_circle_24,
                    0
                )
            }
        }

        return binding.root
    }
}