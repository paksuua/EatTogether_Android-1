package com.example.eattogether_neep.Network.Network

import android.app.Application
import com.example.eattogether_neep.Network.NetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*class ApplicationController : Application(){

    private val baseURL = ""
    lateinit var networkService: NetworkService

    companion object{
        lateinit var instance: ApplicationController
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        buildNetwork()
    }

    fun buildNetwork(){
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        networkService = retrofit.create(NetworkService::class.java)
    }
}*/

object ApplicationController {
    var retrofit= Retrofit.Builder()
        .baseUrl("http://13.125.224.168:8000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var networkService :NetworkService= retrofit.create(NetworkService::class.java)
}

