package com.trydroid.template

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.trydroid.template.views.ToggleTabView
import kotlinx.android.synthetic.main.activity_toggle_tab.*

class ToggleTabActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_toggle_tab)

		val tabDataSet = listOf(
			ToggleTabView.TabItem("Recent"),
			ToggleTabView.TabItem("Editor's Pick", true),
			ToggleTabView.TabItem("Popular"))

		toggleTabView.dataSet = tabDataSet
		toggleTabView.tabClickListener = { _, position ->
			val title = tabDataSet[position].title
			Log.e("Tab Click", "Tab $title, Position $position")
		}
	}
}
