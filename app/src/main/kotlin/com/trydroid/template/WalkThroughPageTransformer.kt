package com.trydroid.template

import android.support.v4.view.ViewPager
import android.view.View

class WalkThroughPageTransformer : ViewPager.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        val absPosition = Math.abs(position)

        // Now it's time for the effects
        if (position <= -1.0f || position >= 1.0f) {
            // The page is not visible. This is a good place to stop
            // any potential work / animations you may have running.
        }
        else if (position === 0.0f) {
            // The page is selected. This is a good time to reset Views
            // after animations as you can't always count on the PageTransformer
            // callbacks to match up perfectly.
        }
        else {
            val alpha = 1.0f - absPosition

            val dummyTitle = page.findViewById(R.id.title)
            dummyTitle.translationX = -position * (pageWidth / 0.8f)
            dummyTitle.alpha = alpha

            val dummyDescription = page.findViewById(R.id.description)
            dummyDescription.translationX = -position * (pageWidth / 1.8f)
            dummyDescription.alpha = alpha

            val dummyImageView = page.findViewById(R.id.customIcon)
            dummyImageView.translationX = -position * (pageWidth / 1.4f)
            dummyImageView.alpha = alpha
        }
    }
}