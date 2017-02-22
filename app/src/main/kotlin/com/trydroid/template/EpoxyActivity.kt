package com.trydroid.template

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.trydroid.template.adapter.SampleAdapter
import kotlinx.android.synthetic.main.activity_epoxy.*

class EpoxyActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_epoxy)
		setupRecyclerView()
		bindEvent()
	}

	private fun setupRecyclerView() {
		recyclerView.layoutManager = LinearLayoutManager(this)
		recyclerView.setHasFixedSize(true)
		recyclerView.adapter = SampleAdapter()
	}

	private fun bindEvent() {
	}
}
