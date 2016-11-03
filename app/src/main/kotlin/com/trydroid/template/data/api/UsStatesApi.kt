package com.trydroid.template.data.api

import com.trydroid.template.data.model.UsStatesRequestEnvelope
import com.trydroid.template.data.model.UsStatesResponseEnvelope
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UsStatesApi {

    @Headers("Content-Type: text/xml", "Accept-Charset: utf-8")
    @POST("/uszip.asmx")
    fun requestStateInfo(@Body body: UsStatesRequestEnvelope): Call<UsStatesResponseEnvelope>
}