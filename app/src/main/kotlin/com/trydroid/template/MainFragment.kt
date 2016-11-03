package com.trydroid.template

import android.os.Bundle
import android.util.Log
import com.trydroid.template.data.api.APIService
import com.trydroid.template.data.api.UsStatesApi
import com.trydroid.template.data.model.UsStatesRequestBody
import com.trydroid.template.data.model.UsStatesRequestData
import com.trydroid.template.data.model.UsStatesRequestEnvelope
import com.trydroid.template.data.model.UsStatesResponseEnvelope
import kotlinx.android.synthetic.main.fragment_main.buttonRequestSOAP
import retrofit2.Call
import retrofit2.Response

class MainFragment : BaseFragment() {
    private val API: UsStatesApi by lazy { APIService().createRestApi(UsStatesApi::class.java) }

    override fun getContentViewId(): Int = R.layout.fragment_main

    override fun bindEvent() {
        buttonRequestSOAP.setOnClickListener { getUseState() }
    }

    override fun onViewReady(savedInstanceState: Bundle?) {
    }

    private fun getUseState() {
        val envelope = UsStatesRequestEnvelope()
        val body = UsStatesRequestBody()
        val data = UsStatesRequestData()
        data.city = "New York"
        body.usStatesRequestData = data
        envelope.body = body

        API.requestStateInfo(envelope)
            .enqueue(object : retrofit2.Callback<UsStatesResponseEnvelope> {
                override fun onResponse(call: Call<UsStatesResponseEnvelope>?, response: Response<UsStatesResponseEnvelope>?) {
                    Log.e("POP", response?.body()?.body?.data?.data?.elements?.toString())
                }

                override fun onFailure(call: Call<UsStatesResponseEnvelope>?, t: Throwable?) {
                    Log.e("onFailure", t?.message)
                }
            })

    }
}