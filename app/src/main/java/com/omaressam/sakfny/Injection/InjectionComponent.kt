package com.omaressam.sakfny.Injection

import com.omaressam.sakfny.UI.home.HomeFragment
import com.omaressam.sakfny.UI.home.HomeViewModel
import dagger.Component


@Component
    (modules = arrayOf(HomeViewModel::class)  )

interface InjectionComponent {
    fun inject(home:HomeFragment)

}