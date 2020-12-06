package com.omaressam.sakfny.Repository

import android.util.Log
import com.omaressam.sakfny.NetworkLayer.Model.Data
import com.omaressam.sakfny.NetworkLayer.RetrofitService
import io.reactivex.Notification
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class RepoArticles   @Inject constructor(     )
 {

    //network object
    lateinit   var retrofitService: RetrofitService
 //Global data resource comman in Network call and repo
    var articlesDataList: List<Data> = ArrayList()
 //Observer that listens data in network-call
    var observer = object : Observer<Notification<List<Data>>>
        {
     override fun onSubscribe(d: Disposable) {
      }

     override fun onNext(t: Notification<List<Data>>) {
         t.value?.let {
             articlesDataList=it
             emitDataToVm(it) }

       Log.d("gded obsrv" , "${t.value}")
     }

     override fun onError(e: Throwable) {

      }

     override fun onComplete() {
      }


 }



   //View model
   // Vm observer
    lateinit var  observerVm: Observer<Notification<List<Data>>>
    //Repo Data  observable for giving data to VM
    lateinit var articlesDataObservableVm : Observable<List<Data>>
    //Observalbe that emits  data to View model
    fun emitDataToVm(articlesDataListVm : List<Data>)
    {
        articlesDataObservableVm  = Observable.create { emitter ->

            emitter.onNext(articlesDataListVm)


            emitter.onError(      Exception("Such error")   )

            emitter.onComplete()
        }
        articlesDataObservableVm.subscribeOn(Schedulers.io()).materialize()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerVm)

    }




   init {
        //Vm observer
       // this.observerVm = observerVm
        //Subscrib Repo with observer
        retrofitService = RetrofitService(observer)





     }


    //network call
    fun getArticles()
    {
        //call network call in courtine here



        retrofitService.getArticles()

         }

    fun getArticles(type:String)
    {
        //call network call in courtine here
        retrofitService.getArticles(type)


  }

    //to Clear Rx Resources
    val compositeDisposable = CompositeDisposable()

    fun clearRx()
          {
              compositeDisposable.clear()
          }






}