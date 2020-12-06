package com.omaressam.sakfny.NetworkLayer

import com.omaressam.sakfny.NetworkLayer.Model.ArticleData
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ApiEndpoints {

    //To get Specfeic catogriy of articles
    @GET("news?access_key=658d2eb76337deecc992cb136e460c13&date=2020-11-23&languages=ar&countries%20=eg")
    fun getArticle(@Query("type")  type:String): Call<ArticleData>

    //To get default Articles by overloading
    @GET("news?access_key=658d2eb76337deecc992cb136e460c13&date=2020-11-23&languages=ar&countries%20=eg")
    fun getArticle(): Call<ArticleData>
}