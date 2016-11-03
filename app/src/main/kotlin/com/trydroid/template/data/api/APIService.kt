package com.trydroid.template.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class APIService {
    private fun createClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    private fun createXMLConverterFactory(): SimpleXmlConverterFactory {
        val strategy = AnnotationStrategy()

        val serializer = Persister(strategy)
        return SimpleXmlConverterFactory.create(serializer)
    }

    fun <T> createRestApi(clazz: Class<T>): T {
        val okHttpClient = createClient()
        val XMLConverter = createXMLConverterFactory()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(XMLConverter)
            .baseUrl("http://www.webservicex.net/")
            .client(okHttpClient)
            .build()

        return retrofit.create(clazz)
    }
}