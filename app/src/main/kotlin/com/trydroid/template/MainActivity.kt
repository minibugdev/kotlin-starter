package com.trydroid.template

import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_layout.fab

class MainActivity : BaseActivity() {

    override fun getFragment(): Fragment = MainFragment()

    override fun bindEvent() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }
    }
}
