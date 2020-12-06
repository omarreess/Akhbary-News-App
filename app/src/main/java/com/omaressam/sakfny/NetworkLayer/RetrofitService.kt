package com.omaressam.sakfny.NetworkLayer

import android.util.Log
import com.omaressam.sakfny.NetworkLayer.Model.ArticleData
import com.omaressam.sakfny.NetworkLayer.Model.Data
import io.reactivex.Notification
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.operators.single.SingleInternalHelper.toObservable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RetrofitService  {

    //Observer that's injected to get data

    lateinit var  observer: Observer<Notification<List<Data>>>

    //Observalbe that emits network-call-data to Repo , called in Netowork call

   lateinit var articlesDataListSubject : Observable<List<Data>>
       fun emitDataToRepo(articlesDataList : List<Data>)
       {
             articlesDataListSubject  = Observable.create { emitter ->

               emitter.onNext(articlesDataList)


               emitter.onError(      Exception("Such error")   )

               emitter.onComplete()
       }
           articlesDataListSubject.subscribeOn(Schedulers.io()).materialize()
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(observer)

    }

    constructor (observer :Observer<Notification<List<Data>>>){
        this.observer=observer
     }



    //getting Genaral articles
       fun getArticles()
    {    runBlocking (Dispatchers.IO){ async { val call: Call<ArticleData> = ApiClient.getClient.getArticle()
        call.enqueue(object : Callback<ArticleData> {

            override fun onResponse(call: Call<ArticleData> , response: Response<ArticleData>?) {
                response ?.body() ?.data?.let { emitDataToRepo(it) }
              }

            override fun onFailure(call: Call<ArticleData>?, t: Throwable?) {
                Log.d("network call", "t?.message")

            }

        }) }.await()

    }



    }


    // if there paramter to get specfiec type
     fun getArticles(type:String)
    {
        val call: Call<ArticleData> = ApiClient.getClient.getArticle(type)
        call.enqueue(object : Callback<ArticleData> {

            override fun onResponse(call: Call<ArticleData>?, response: Response<ArticleData>?) {
                response ?.body() ?.data?.let { emitDataToRepo(it) }

            }

            override fun onFailure(call: Call<ArticleData>?, t: Throwable?) {
                Log.d("network call", "")
            }

        })
    }

 }