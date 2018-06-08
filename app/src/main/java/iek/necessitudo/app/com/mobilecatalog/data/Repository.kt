package iek.necessitudo.app.com.mobilecatalog.data

import android.content.Context
import android.graphics.ColorSpace
import android.util.Base64
import android.widget.Toast
import iek.necessitudo.app.com.mobilecatalog.data.rest.Model
import iek.necessitudo.app.com.mobilecatalog.data.rest.RestClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class Repository(val context: Context) {

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
                               { error -> Toast.makeText(context, error.message, Toast.LENGTH_LONG).show() }
                       )

        return true

   }

    fun showSuccess(result: List<Model.GroupDDP>){
        val a = 0
    }

    fun showError(result:Throwable){
        val a=0
    }


    fun getAuthToken():String {

        val authData = Authentification.login+":"+Authentification.password

        val data = authData.toByteArray()

        return "Basic "+ Base64.encodeToString(data, Base64.NO_WRAP)


    }


}
