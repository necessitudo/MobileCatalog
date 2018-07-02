package iek.necessitudo.app.com.mobilecatalog.data.rest

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RestClient {

    companion object {

        fun create() : ApiService {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(
                            CoroutineCallAdapterFactory())
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl("https://www.iek.ru/api/")
                    .build()

            return retrofit.create(ApiService::class.java)

        }

    }
}