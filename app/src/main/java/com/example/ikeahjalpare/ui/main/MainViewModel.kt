package com.example.ikeahjalpare.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ikeahjalpare.dto.Furniture
import com.example.ikeahjalpare.service.FurnitureService

class MainViewModel : ViewModel() {
    var furnitures: MutableLiveData<ArrayList<Furniture>> = MutableLiveData()
    var furnitureService: FurnitureService = FurnitureService()
    fun fetchFurnitures() {
        furnitures = furnitureService.fetchFurnitures()
    }
}