package iek.necessitudo.app.com.mobilecatalog.domain.interactor


import iek.necessitudo.app.com.mobilecatalog.data.Repository
import iek.necessitudo.app.com.mobilecatalog.domain.model.GroupDDP
import javax.inject.Inject

class CatalogInteractor {

    @Inject
    lateinit var repository: Repository

    fun getGroupDDP():List<GroupDDP>{

        val groups = repository.getAllGroupDDP()

        return emptyList()

    }

}