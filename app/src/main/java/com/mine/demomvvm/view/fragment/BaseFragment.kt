package com.mine.demomvvm.view.fragment

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.support.v4.app.Fragment

class BaseFragment : Fragment() {

    fun isNetworkAvailable(actvity: Activity): Boolean {
        val returnValue: Boolean?
        val connectivityManager = actvity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        returnValue = activeNetworkInfo != null && activeNetworkInfo.isConnected
        return returnValue
    }


}