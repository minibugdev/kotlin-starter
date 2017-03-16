package com.trydroid.template.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckedTextView
import com.google.android.flexbox.FlexboxLayout
import com.trydroid.template.R
import kotlin.properties.Delegates

typealias OnTagClickListener = (tagView: View, position: Int) -> Unit

class TagView : FlexboxLayout {
	private val mLayoutInflater by lazy { LayoutInflater.from(context) }

	var tagItemList: List<TagItem>? by Delegates.observable(null as List<TagItem>?) { _, _, newValue ->
		newValue?.let { addTagList(newValue) }
	}

	var tagClickListener: OnTagClickListener? = null

	constructor(context: Context) : super(context)
	constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
	constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

	private fun addTagList(tabList: List<TagItem>) {
		tabList.forEach { tagItem ->
			addTagView(tagItem)
		}

		tabList.indexOfLast(TagItem::isActive)
			.let { lastActive -> updateActive(lastActive) }
	}

	private fun addTagView(tagItem: TagItem) {
		val tagView = createTag(tagItem)
		tagView?.let { addView(tagView) }
	}

	private fun createTag(tagItem: TagItem): View? {
		val tag = mLayoutInflater.inflate(R.layout.view_tag, this, false)
		if (tag is CheckedTextView) {
			tag.text = tagItem.text
			tag.isEnabled = tagItem.isEnable
			tag.isClickable = true
			tag.setOnClickListener(mOnClickListener)
			return tag
		}

		return null
	}

	private val mOnClickListener = View.OnClickListener { view ->
		val position = indexOfChild(view)
		if (position > -1) {
			updateActive(position)
			tagClickListener?.invoke(view, position)
		}
	}

	private fun updateActive(position: Int) {
		val activeView = getChildAt(position)
		activeView?.let {
			val childCount = childCount
			(0..childCount).forEach { index ->
				val tagView = getChildAt(index)
				if (tagView is CheckedTextView) {
					tagView.isChecked = tagView == activeView
				}
			}
		}
	}

	data class TagItem(val text: String, var isActive: Boolean = false, var isEnable: Boolean = true)
}