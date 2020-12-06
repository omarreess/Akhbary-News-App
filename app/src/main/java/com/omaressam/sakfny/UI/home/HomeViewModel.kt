package com.omaressam.sakfny.UI.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.omaressam.sakfny.NetworkLayer.Model.Data
import com.omaressam.sakfny.Repository.RepoArticles
import com.omaressam.sakfny.Util.GlideApp
import com.omaressam.sakfny.Util.GlideModuleApp
import dagger.Module
import dagger.Provides
import io.reactivex.Notification
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject
@Module
class HomeViewModel @Inject constructor(var repoArticles :RepoArticles) : ViewModel() {

//       //Repo
//     lateinit var repoArticles :RepoArticles

      //Observer that listens data in Repo
      //Subscribe to Repo

      fun provideRepoObserver ( ) :Observer<Notification<List<Data>>>
      {
          return object : Observer<Notification<List<Data>>> {
              override fun onSubscribe(d: Disposable) {
              }

              override fun onNext(t: Notification<List<Data>>) {
                  t.value?.let {
                      articleDataList.postValue(it)
                  }


              }

              override fun onError(e: Throwable) {

              }

              override fun onComplete() {
              }
          }
      }



     //View
    //LiveData Observable Holds data To View
     var  articleDataList:  MutableLiveData<List<Data>> = MutableLiveData<List<Data>>()



   init {
       //Subscribe to Repo
      // repoArticles = RepoArticles(observerRepo)
       repoArticles.observerVm = provideRepoObserver()

       //getting default Articles
        getArticles()

  }




    //Request Repo getting Data
    fun getArticles()
    {
         repoArticles.getArticles()

    }
    fun getArticles(type:String)
    {
        repoArticles.getArticles(type)
    }

}