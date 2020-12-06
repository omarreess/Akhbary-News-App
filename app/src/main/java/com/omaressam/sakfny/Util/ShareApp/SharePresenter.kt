package com.omaressam.sakfny.Util.ShareApp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.google.android.material.snackbar.Snackbar

class SharePresenter   : ShareContract {





    override fun fetchUri() : String {


      return "https://play.google.com/store/apps/details?id=com.omaressam.sakfny"
    }


}