package com.mine.demomvvm.view.fragment.splash


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mine.demomvvm.R
import com.mine.demomvvm.view.activity.login.LoginActivity

/**
 * A simple [Fragment] subclass.
 *
 */
class SplashScreenFragment : Fragment() {

    companion object Factory{
        fun newInstance(): SplashScreenFragment = SplashScreenFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moveToHome()
    }

    private fun moveToHome() {
        Handler().postDelayed({
            startActivity(Intent(activity,LoginActivity::class.java))
        },3000)

    }


}
