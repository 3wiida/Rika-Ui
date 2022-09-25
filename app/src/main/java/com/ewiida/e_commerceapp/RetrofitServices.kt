package com.ewiida.e_commerceapp

import com.ewiida.e_commerceapp.api.RikaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServices {
    private const val BASE_URL="http://shop.corptia.xyz/api/"
    private val client=UnsafeOkHttpClient.getUnsafeOkHttpClient()

    private fun retrofit():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).client(client.build()).addConverterFactory(GsonConverterFactory.create()).build()
    }

    var rServices= retrofit().create(RikaApi::class.java)




}