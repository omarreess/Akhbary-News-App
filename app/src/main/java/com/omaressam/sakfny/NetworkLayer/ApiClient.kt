package com.omaressam.sakfny.NetworkLayer

import com.google.gson.GsonBuilder
//import io.reactivex.Observable

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import rx.Observable

//import rx.Observable

object ApiClient {


        var BASE_URL:String="http://api.mediastack.com/v1/"
        val getClient: ApiEndpoints
            get() {

                val gson = GsonBuilder()
                    .setLenient()
                    .create()
                val interceptor = HttpLoggingInterceptor()
                interceptor.level=HttpLoggingInterceptor.Level.BODY
                val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))

                    .build()

                return retrofit.create(ApiEndpoints::class.java)

            }


}