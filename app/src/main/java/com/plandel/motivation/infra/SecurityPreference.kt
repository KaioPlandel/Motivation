package com.plandel.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreference(context: Context) {

    private val shared: SharedPreferences = context.getSharedPreferences("motivation",Context.MODE_PRIVATE)

    fun storeString(key:String,value: String){
        shared.edit().putString(key,value).apply()
    }

    fun getString(key: String): String{
       return shared.getString(key,"") ?: ""
    }
}