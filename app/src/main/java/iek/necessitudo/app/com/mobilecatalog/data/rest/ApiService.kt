package iek.necessitudo.app.com.mobilecatalog.data.rest

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("ddp")
    fun getGroupsDDP (@Header("Authorization") authkey:String): Observable<List<Model.GroupDDP>>
}


