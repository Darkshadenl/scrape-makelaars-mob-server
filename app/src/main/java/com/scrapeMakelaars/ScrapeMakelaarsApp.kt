package com.scrapeMakelaars

import android.app.Application
import androidx.core.os.BuildCompat
import com.scrapeMakelaars.inversion.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ScrapeMakelaarsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ScrapeMakelaarsApp)
            modules(appModule)
        }
    }
}