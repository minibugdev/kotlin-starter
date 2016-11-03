package com.trydroid.template

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_layout.toolbar

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, getFragment())
            .commit()

        bindEvent()
    }

    abstract fun getFragment(): Fragment

    abstract fun bindEvent()
}
