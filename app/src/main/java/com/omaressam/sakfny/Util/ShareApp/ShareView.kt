package com.omaressam.sakfny.Util.ShareApp

interface ShareView {


    fun toWhatsappShare(uri: String)
    fun toMessngerShare(uri: String)
    fun toInstaShare(uri: String)
    fun toTwiiterShare(uri: String)
    fun bindLink(uri: String)
    fun copylink(uri:String)



}