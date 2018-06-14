package iek.necessitudo.app.com.mobilecatalog.presentation.mvp

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {


    init {
        //MobileCatalogApplication.graph.inject(this)
    }

    fun testClick(){

        val a = 0
    }



}