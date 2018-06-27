package iek.necessitudo.app.com.mobilecatalog.data

import android.content.Context
import android.util.Base64
import android.util.Log
import android.widget.Toast
import iek.necessitudo.app.com.mobilecatalog.data.rest.RestClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class Repository() {

    val apiService by lazy {
        RestClient.create()
    }

    var disposable: Disposable? = null

   fun getAllGroupDDP(): Boolean{

       disposable =
               apiService.getGroupsDDP(getAuthToken())
                       .subscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread())
                       .subscribe(
                               { result -> showSuccess(result) },
                               { error -> showError(error) }
                       )

        return true

   }

    fun showSuccess(result: List<GroupDDP>){
    }

    fun showError(result:Throwable){
    }


    fun getAuthToken():String {

        val authData = Authentification.login+":"+Authentification.password

        val data = authData.toByteArray()

        return "Basic "+ Base64.encodeToString(data, Base64.NO_WRAP)


    }


}
