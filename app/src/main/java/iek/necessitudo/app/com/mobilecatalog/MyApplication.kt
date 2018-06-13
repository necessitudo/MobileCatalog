package iek.necessitudo.app.com.mobilecatalog

import android.app.Application
import iek.necessitudo.app.com.mobilecatalog.di.AppComponent
import iek.necessitudo.app.com.mobilecatalog.di.DaggerAppComponent
import iek.necessitudo.app.com.mobilecatalog.di.ManagerModule

class MyApplication : Application() {

    companion object {
        lateinit var graph : AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        graph = DaggerAppComponent.builder().build()
    }

}