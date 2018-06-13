package iek.necessitudo.app.com.mobilecatalog.di

import dagger.Module
import dagger.Provides
import iek.necessitudo.app.com.mobilecatalog.presentation.fragment.AppFragmentManager
import javax.inject.Singleton

@Module
class ManagerModule {

    @Singleton
    @Provides
     fun provideFragmentManager() : AppFragmentManager {return AppFragmentManager()}


}