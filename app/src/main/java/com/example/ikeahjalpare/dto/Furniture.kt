package com.example.ikeahjalpare.dto

import com.google.gson.annotations.SerializedName

data class Furniture (
    @SerializedName("id")var ID:Int,
    @SerializedName("article_number")var articleNumber:String,
    @SerializedName("furniture_name") var furnitureName: String,
    @SerializedName("video_link") var videoLink:String,
    @SerializedName("instructions_manuel")var instructionsManuel: String)
{
    override fun toString() = "$articleNumber $furnitureName $videoLink $instructionsManuel"

}