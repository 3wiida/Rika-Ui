package com.ewiida.e_commerceapp.utils.sharedpreferences

import android.content.Context

class prefUtils {

    companion object{
        @JvmStatic
        fun savePref(context: Context,key:String,value:String){
            var sharedPref=androidx.preference.PreferenceManager.getDefaultSharedPreferences(context).edit()
            sharedPref.putString(key,value)
            sharedPref.apply()
        }
    }

}