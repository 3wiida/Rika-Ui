package com.ewiida.e_commerceapp

import com.ewiida.e_commerceapp.api.RikaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServices {
    // Test

    private const val BASE_URL="https://shop.corptia.xyz/api/"


    private fun retrofit():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    var rServices= retrofit().create(RikaApi::class.java)




}