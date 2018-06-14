package iek.necessitudo.app.com.mobilecatalog.di

import dagger.Component
import iek.necessitudo.app.com.mobilecatalog.presentation.MainActivity
import iek.necessitudo.app.com.mobilecatalog.presentation.activity.BaseActivity
import iek.necessitudo.app.com.mobilecatalog.presentation.mvp.MainPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [ManagerModule::class])
interface AppComponent {

    fun inject(activity: BaseActivity)
}