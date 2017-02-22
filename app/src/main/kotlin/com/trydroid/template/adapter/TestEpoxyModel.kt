package com.trydroid.template.adapter

import android.support.annotation.ColorInt
import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelClass
import com.trydroid.template.R

@EpoxyModelClass(layout = R.layout.model_epoxy)
abstract class TestEpoxyModel(@JvmField @EpoxyAttribute @ColorInt protected var color: Int) : EpoxyModel<View>() {

	override fun bind(view: View?) {
		view?.setBackgroundColor(color)
	}
}