package com.mine.demomvvm.view.activity.splash

import android.os.Bundle
import com.mine.demomvvm.R
import com.mine.demomvvm.view.activity.BaseActivity
import com.mine.demomvvm.view.fragment.splash.SplashScreenFragment
import com.mine.demomvvm.view.utility.DisplayInfo

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DisplayInfo.showProgressBar(this)
        loadFragment()
    }

    private fun loadFragment() {
        val fragment = SplashScreenFragment.newInstance()
        setFragment(R.id.containerId,fragment,true)
    }
}
