package com.ewiida.e_commerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)

        sayFuck()
    }

    private fun sayFuck(){
        Log.i("hi", "hi mahmoud")
    }

    fun sayhi(){
        Log.d("tag","hi")
    }
}