package com.trydroid.template.adapter

import android.graphics.Color
import com.airbnb.epoxy.EpoxyAdapter
import java.util.*


internal class SampleAdapter : EpoxyAdapter() {

	init {
		// We are going to use automatic diffing, so we just have to enable it first
		enableDiffing()

		addModels(listOf(
			TestEpoxyModel_(randomColor()),
			TestEpoxyModel_(randomColor()),
			TestEpoxyModel_(randomColor()),
			TestEpoxyModel_(randomColor()),
			TestEpoxyModel_(randomColor()),
			TestEpoxyModel_(randomColor()),
			TestEpoxyModel_(randomColor()),
			TestEpoxyModel_(randomColor()),
			TestEpoxyModel_(randomColor()),
			TestEpoxyModel_(randomColor()),
			TestEpoxyModel_(randomColor()),
			TestEpoxyModel_(randomColor()),
			TestEpoxyModel_(randomColor())
		))
	}

	private fun randomColor(): Int {
		val r = RANDOM.nextInt(256)
		val g = RANDOM.nextInt(256)
		val b = RANDOM.nextInt(256)

		return Color.rgb(r, g, b)
	}

	companion object {
		private val RANDOM = Random()
	}
}
