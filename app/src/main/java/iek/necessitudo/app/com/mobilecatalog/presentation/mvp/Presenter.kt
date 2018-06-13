package iek.necessitudo.app.com.mobilecatalog.presentation.mvp

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import iek.necessitudo.app.com.mobilecatalog.MyApplication
import iek.necessitudo.app.com.mobilecatalog.presentation.fragment.AppFragmentManager
import javax.inject.Inject

@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {

    @Inject
    lateinit var fragmentManager:AppFragmentManager

    init {
        MyApplication.graph.inject(this)
    }

    fun testClick(){

        val a = 0
    }



}