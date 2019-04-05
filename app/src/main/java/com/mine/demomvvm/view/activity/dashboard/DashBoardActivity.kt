package com.mine.demomvvm.view.activity.dashboard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mine.demomvvm.R
import com.mine.demomvvm.view.activity.BaseActivity
import com.mine.demomvvm.view.fragment.dashboard.DashboardFragment

class DashBoardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment()
    }

    private fun loadFragment() {
        val fragment = DashboardFragment.newInstance()
        setFragment(R.id.containerId,fragment,true)
    }
}
