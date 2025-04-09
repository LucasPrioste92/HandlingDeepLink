package com.lucasprioste.handlingdeeplink

import android.app.Application
import com.lucasprioste.handlingdeeplink.di.InitDI
import org.koin.android.ext.koin.androidContext

class HandlingDeepLinkApp: Application() {
    override fun onCreate() {
        super.onCreate()
        InitDI.doInit {
            androidContext(this@HandlingDeepLinkApp)
        }
    }
}