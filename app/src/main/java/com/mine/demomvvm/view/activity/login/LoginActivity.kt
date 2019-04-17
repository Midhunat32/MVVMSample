package com.mine.demomvvm.view.activity.login

import android.app.Application
import android.os.Bundle
import com.mine.demomvvm.R
import com.mine.demomvvm.view.activity.BaseActivity
import com.mine.demomvvm.view.fragment.login.LoginFragment

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment()
    }

    private fun loadFragment() {
        val fragment = LoginFragment.newInstance()
        var resId = R.id.containerId
        setFragment(resId,fragment,false)
    }
}
