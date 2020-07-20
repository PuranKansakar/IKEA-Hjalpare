package com.example.ikeahjalpare.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ikeahjalpare.dto.Furniture
import com.example.ikeahjalpare.service.FurnitureService

class MainViewModel : ViewModel() {
    private var _furnitures: MutableLiveData<ArrayList<Furniture>> = MutableLiveData<ArrayList<Furniture>>()
    var furnitureService: FurnitureService = FurnitureService()
    init {
        fetchFurnitures("FurnitureName")
    }
    fun fetchFurnitures(FurnitureName: String) {
        _furnitures = furnitureService.fetchFurnitures(FurnitureName)
    }

    internal var furnitures: MutableLiveData<ArrayList<Furniture>>
        get() {return _furnitures}
        set(value: MutableLiveData<java.util.ArrayList<Furniture>>) { _furnitures.value}
}