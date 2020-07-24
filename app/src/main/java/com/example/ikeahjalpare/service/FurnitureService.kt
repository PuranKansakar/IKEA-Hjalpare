package com.example.ikeahjalpare.service

import androidx.lifecycle.MutableLiveData
import com.example.ikeahjalpare.RetrofitClientInstance
import com.example.ikeahjalpare.dao.IFurnitureDAO
import com.example.ikeahjalpare.dto.Furniture
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FurnitureService {
    fun fetchFurniture(): MutableLiveData<ArrayList<Furniture>> {
        //MVD is defined
        var furniture = MutableLiveData<ArrayList<Furniture>>()
        val service = RetrofitClientInstance.retrofitInstance?.create(IFurnitureDAO::class.java)
        val call = service?.getAllFurniture()

        call?.enqueue(object : Callback<ArrayList<Furniture>> {
            //Call onFailure to determine if the response indicates success.
            override fun onFailure(call: Call<ArrayList<Furniture>>, t: Throwable) {
                val j = 1 + 1
                val i = 1 + 1
                // throw Exception("Unable to read json file")
            }

            //Call onResponse to determine if the response indicates success.
            override fun onResponse(
                call: Call<ArrayList<Furniture>>,
                response: Response<ArrayList<Furniture>>
            ) {
                furniture.value = response.body()
            }
        })
        return furniture
    }
}