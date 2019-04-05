package com.mine.demomvvm.view.activity

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import org.jetbrains.annotations.NotNull

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setFragment(@IdRes containerId: Int, @NotNull fragment: Fragment, addTobackStack: Boolean) {
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(containerId, fragment)
        if (addTobackStack) {
            fragmentTransition.addToBackStack(fragment.javaClass.simpleName)
        }
        fragmentTransition.commit()
    }

    fun isNetworkAvailable(): Boolean {
        val returnValue: Boolean?
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        returnValue = activeNetworkInfo != null && activeNetworkInfo.isConnected
        return returnValue
    }


    override fun onBackPressed() {
        super.onBackPressed()
        val stackEntryCount = supportFragmentManager.backStackEntryCount
        if (0 < stackEntryCount) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }


}
