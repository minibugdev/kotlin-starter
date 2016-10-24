package com.trydroid.template

import android.os.Bundle
import android.support.annotation.ColorInt
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PlaceholderFragment : Fragment() {
    private var mPage: Int = -1
    private var mBackgroundColor: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args = arguments
        if (args.containsKey(ARG_PAGE)) mPage = args.getInt(ARG_PAGE)
        if (args.containsKey(ARG_BACKGROUND_COLOR)) mBackgroundColor = args.getInt(ARG_BACKGROUND_COLOR)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layoutResId =
            when (mPage) {
                0 -> R.layout.fragment_intro_1
                1 -> R.layout.fragment_intro_2
                2 -> R.layout.fragment_intro_3
                else -> throw IllegalArgumentException("Page is Invalid.")
            }

        return inflater.inflate(layoutResId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (mBackgroundColor == -1)
            throw IllegalArgumentException("Background Color is Invalid.")

        val background = view.findViewById(R.id.layoutIntroBackground)
        background.setBackgroundColor(mBackgroundColor)
    }

    companion object {
        private val ARG_PAGE = "section_number"
        private val ARG_BACKGROUND_COLOR = "background_color"

        fun newInstance(@ColorInt backgroundColor: Int, page: Int): PlaceholderFragment {
            val fragment = PlaceholderFragment()
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            args.putInt(ARG_BACKGROUND_COLOR, backgroundColor)
            fragment.arguments = args
            return fragment
        }
    }
}