package com.example.ikeahjalpare.dao

import com.example.ikeahjalpare.dto.Furniture
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IFurnitureDAO {
    //Created DAO class for
    @GET("/dbc64a5b111a92183e33.json")
    fun getAllFurnitures(): Call <ArrayList<Furniture>>

    @GET("/dbc64a5b111a92183e33")
    fun getFurniture(@Query("Combined_Name")furnitureName:String) : Call <ArrayList<Furniture>>
}