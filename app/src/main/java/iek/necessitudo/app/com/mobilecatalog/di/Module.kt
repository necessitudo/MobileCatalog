package iek.necessitudo.app.com.mobilecatalog.di

import dagger.Module
import dagger.Provides
import iek.necessitudo.app.com.mobilecatalog.data.Repository
import iek.necessitudo.app.com.mobilecatalog.domain.interactor.CatalogInteractor
import iek.necessitudo.app.com.mobilecatalog.presentation.common.FragmentManager
import javax.inject.Singleton

@Module
class ManagerModule {

    @Singleton
    @Provides
    fun provideFragmentManager() : FragmentManager {return FragmentManager()}

    @Singleton
    @Provides
    fun provideRepository() : Repository {return Repository()}

    @Singleton
    @Provides
    fun provideCatalogInteractor() : CatalogInteractor {return CatalogInteractor()}


}