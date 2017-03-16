package com.trydroid.template

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.trydroid.template.views.TagView
import kotlinx.android.synthetic.main.activity_tag.*

class TagActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_tag)

		tagView.tagItemList = listOf(
			TagView.TagItem("AAAAAAA"),
			TagView.TagItem("BBB"),
			TagView.TagItem("CCCCC"),
			TagView.TagItem("EEEEEEEEE"),
			TagView.TagItem("FF"),
			TagView.TagItem("GGGGG"),
			TagView.TagItem("HHHHHHHHH", isActive = true),
			TagView.TagItem("IIII"),
			TagView.TagItem("JJJ"),
			TagView.TagItem("KKKKKKKK"),
			TagView.TagItem("EEEE", isActive = true),
			TagView.TagItem("GGGGGGGGGGGGGGGGGG"))

		tagView.tagClickListener = { _, position ->
			Log.e("Tag click", "Position " + position)
		}
	}
}
