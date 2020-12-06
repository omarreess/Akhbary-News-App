package com.omaressam.sakfny.Injection

import com.omaressam.sakfny.UI.home.HomeFragment

class HomeInjector {


      var component: InjectionComponent
    init {
        component = DaggerInjectionComponent.builder().build()
    }
   fun injectHome(home : HomeFragment)
    {


       component.inject( home)
   }

}