package com.trydroid.template

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_rxjava.*

class RxJavaActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_rxjava)

		buttonTest.setOnClickListener {
			testRxJava()
		}
	}

	private fun testRxJava() {
		Observable.error<String>(NullPointerException())
			.doOnSubscribe { Log.e("Tag", "doOnSubscribe") }
			.doOnComplete { Log.e("Tag", "doOnComplete") }
			.doOnDispose { Log.e("Tag", "doOnDispose") }
			.doOnTerminate { Log.e("Tag", "doOnTerminate") }
			.doOnError { Log.e("Tag", "doOnError") }
			.doFinally { Log.e("Tag", "doFinally") }
			.subscribe(
				{
					Log.e("Tag", "Result : " + it)
				},
				{ e ->
					Log.e("Tag", "Error : " + e.message)
				})
	}
}