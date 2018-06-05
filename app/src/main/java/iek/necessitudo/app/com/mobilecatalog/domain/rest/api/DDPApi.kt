package iek.necessitudo.app.com.mobilecatalog.domain.rest.api

import iek.necessitudo.app.com.mobilecatalog.domain.rest.model.GroupDDP
import io.reactivex.Observable
import retrofit2.http.GET

interface DDPApi {
    @GET("ddp")
    fun getGroupsDDP (): Observable<List<GroupDDP>>

}

