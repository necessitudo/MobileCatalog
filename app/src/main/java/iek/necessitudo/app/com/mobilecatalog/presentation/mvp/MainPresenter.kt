package iek.necessitudo.app.com.mobilecatalog.presentation.mvp

import android.support.annotation.IdRes
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import iek.necessitudo.app.com.mobilecatalog.R
import iek.necessitudo.app.com.mobilecatalog.presentation.common.MenuFragment
import iek.necessitudo.app.com.mobilecatalog.presentation.fragment.CatalogFragment
import iek.necessitudo.app.com.mobilecatalog.presentation.fragment.FavoritesFragment

@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {


    init {
        //MobileCatalogApplication.graph.inject(this)
    }


    fun selectBottomMenuItem(@IdRes itemId:Int):Boolean{

        when (itemId) {
            R.id.navigation_home -> {

                viewState.setMenuHome(MenuFragment())
                return true
            }
            R.id.navigation_catalog -> {

                viewState.setContent(CatalogFragment())
                return  true
            }
            R.id.navigation_favorities -> {

                viewState.setContent(FavoritesFragment())
                return true
            }
            R.id.navigation_search -> {

                return true
            }
        }
        return false
    }


}