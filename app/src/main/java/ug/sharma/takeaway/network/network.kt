package ug.sharma.takeaway.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ug.sharma.takeaway.api.Apiclient
import java.util.logging.Logger

object network {

    private val base="https://api.tvmaze.com/"



    fun getDataByNetwork(): Apiclient {

        val retrofit = Retrofit.Builder()
            .baseUrl(base)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        return retrofit.create(Apiclient::class.java)
    }

}