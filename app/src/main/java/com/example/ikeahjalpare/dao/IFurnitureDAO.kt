package com.example.ikeahjalpare.dao

import com.example.ikeahjalpare.dto.Furniture
import retrofit2.Call
import retrofit2.http.GET

interface IFurnitureDAO {
    //Created DAO class for
    @GET("/dbc64a5b111a92183e33.json")
    fun getAllFurniture(): Call<ArrayList<Furniture>>

    @GET("/dbc64a5b111a92183e33")
    fun getFurniture(furniture_name: String): Call<ArrayList<Furniture>>
}