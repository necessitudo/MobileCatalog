package iek.necessitudo.app.com.mobilecatalog.presentation.mvp

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import iek.necessitudo.app.com.mobilecatalog.MobileCatalogApplication
import iek.necessitudo.app.com.mobilecatalog.domain.interactor.CatalogInteractor
import javax.inject.Inject

@InjectViewState
class CatalogPresenter: MvpPresenter<FragmentView>() {

    @Inject
    lateinit var catalogInteractor: CatalogInteractor


    init {
        MobileCatalogApplication.graph.inject(this)
    }

fun loadStart(){
    catalogInteractor.getGroupDDP()
    //viewState.addItems()
}
}