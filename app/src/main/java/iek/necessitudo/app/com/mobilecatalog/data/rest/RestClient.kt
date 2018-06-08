package iek.necessitudo.app.com.mobilecatalog.data.rest

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RestClient {

    companion object {

        fun create() : ApiService {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl("https://www.iek.ru/api/")
                    .build()

            return retrofit.create(ApiService::class.java)

        }

    }
}