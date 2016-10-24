package com.trydroid.template

import android.graphics.Color
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        val colorRes = when (position) {
            0 -> Color.parseColor("#03A9F4")
            1 -> Color.parseColor("#4CAF50")
            2 -> Color.parseColor("#F44E03")
            else  -> throw IllegalArgumentException("Position is Invalid.")
        }
        return PlaceholderFragment.newInstance(colorRes, position)
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "SECTION 1"
            1 -> return "SECTION 2"
            2 -> return "SECTION 3"
        }
        return null
    }
}