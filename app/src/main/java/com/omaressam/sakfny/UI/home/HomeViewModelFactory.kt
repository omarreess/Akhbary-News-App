package com.omaressam.sakfny.UI.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.omaressam.sakfny.Repository.RepoArticles
import javax.inject.Inject



class HomeViewModelFactory
    @Inject constructor( var repo: RepoArticles  )
    : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repo) as T
    }
}