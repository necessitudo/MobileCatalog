package iek.necessitudo.app.com.mobilecatalog.di

import dagger.Component
import iek.necessitudo.app.com.mobilecatalog.domain.interactor.CatalogInteractor
import iek.necessitudo.app.com.mobilecatalog.presentation.MainActivity
import iek.necessitudo.app.com.mobilecatalog.presentation.mvp.CatalogPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [ManagerModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(interactor: CatalogInteractor)
    fun inject(presenter:CatalogPresenter)

}