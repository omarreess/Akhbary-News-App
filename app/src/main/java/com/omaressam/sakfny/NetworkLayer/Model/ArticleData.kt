package com.omaressam.sakfny.NetworkLayer.Model


import com.google.gson.annotations.SerializedName

data class ArticleData(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("pagination")
    val pagination: Pagination
)