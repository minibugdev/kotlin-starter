package com.trydroid.template

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mSectionsPagerAdapter: SectionsPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()
        bindEvent()
    }

    private fun setupViewPager() {
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        viewPager.adapter = mSectionsPagerAdapter
        viewPager.setPageTransformer(false, IntroPageTransformer())
    }

    private fun bindEvent() {
    }
}
