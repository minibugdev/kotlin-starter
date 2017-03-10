package com.trydroid.template.views

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.TextView
import com.trydroid.template.R
import kotlin.properties.Delegates

typealias OnTabClickListener = (tabView: View, position: Int) -> Unit

class ToggleTabView : CardView {
	private lateinit var mRootView: LinearLayout

	var dataSet: List<TabItem>? by Delegates.observable(null as List<TabItem>?) { _, _, newValue ->
		newValue?.let {
			addTabList(newValue)
		}
	}

	var tabClickListener: OnTabClickListener? = null

	constructor(context: Context) : super(context) {
		init(context, null)
	}

	constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
		init(context, attrs)
	}

	constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
		init(context, attrs)
	}

	private fun init(ctx: Context, attrs: AttributeSet?) {
		setContentPadding(0, 0, 0, 0)
		preventCornerOverlap = false
		useCompatPadding = true
		clipToPadding = true

		mRootView = LinearLayout(ctx)
		mRootView.layoutParams = RadioGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 3f)
		mRootView.orientation = RadioGroup.HORIZONTAL

		addView(mRootView)
	}

	private fun addTabList(tabList: List<TabItem>) {
		val lastIndex = tabList.lastIndex
		val ctx = context
		tabList.forEachIndexed { index, tabItem ->
			val tabView = createTab(ctx, tabItem.title)
			setTabActive(tabView, tabItem.isActive)
			addTabView(tabView)

			if (index < lastIndex) {
				addSeparatorView()
			}
		}
	}

	private fun createTab(ctx: Context, text: String): TextView {
		val tab = TextView(ctx)
		tab.setBackgroundResource(R.drawable.selector_tab)
		tab.layoutParams = createTabLayoutParams()
		tab.gravity = Gravity.CENTER
		tab.text = text
		tab.setOnClickListener(mOnClickListener)

		return tab
	}

	private fun createSeparatorView(ctx: Context): View {
		val color = ContextCompat.getColor(ctx, R.color.colorAccent)
		val separatorView = View(ctx)
		separatorView.setBackgroundColor(color)
		separatorView.layoutParams = LinearLayout.LayoutParams(1, LayoutParams.MATCH_PARENT)

		return separatorView
	}

	private fun createTabLayoutParams(): LinearLayout.LayoutParams {
		val tabHeight = context.resources.getDimensionPixelSize(R.dimen.button_height)
		return LinearLayout.LayoutParams(0, tabHeight, 1f)
	}

	private fun setTabActive(tabView: TextView, isActive: Boolean) {
		if (isActive) {
			tabView.setTextColor(ContextCompat.getColor(context, R.color.red))
		}
		else {
			tabView.setTextColor(ContextCompat.getColor(context, R.color.gray))
		}
	}

	private fun addTabView(view: View) {
		mRootView.addView(view)
	}

	private fun addSeparatorView() {
		mRootView.addView(createSeparatorView(context))
	}

	private val mOnClickListener = View.OnClickListener { view ->
		val childCount = mRootView.childCount
		var activeIndex = -1
		var tabIndex = 0
		(0..childCount).forEach { index ->
			val tabView = mRootView.getChildAt(index)
			if (tabView is TextView) {
				val tabItem = dataSet!![tabIndex]
				if (view == tabView) {
					tabItem.isActive = true
					setTabActive(tabView, true)

					activeIndex = tabIndex
				}
				else {
					tabItem.isActive = false
					setTabActive(tabView, false)
				}

				tabIndex += 1
			}
		}

		tabClickListener?.invoke(view, activeIndex)
	}

	data class TabItem(val title: String, var isActive: Boolean = false)
}