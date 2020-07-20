package com.example.ikeahjalpare.ui.main

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {

    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://api.npoint.io"

    val retrofitInstance : Retrofit?
        get(){
            // object has been created
            if (retrofit == null){ //defined
                // create it
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL) //base url defined
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }       //return retrofit
            return retrofit
        }
}