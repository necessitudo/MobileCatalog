package iek.necessitudo.app.com.mobilecatalog.data.rest

import iek.necessitudo.app.com.mobilecatalog.data.model.GroupDDP
import io.reactivex.Observable
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("ddp")
    fun getGroupsDDP (@Header("Authorization") authkey:String): Deferred<List<GroupDDP>>
}


