package com.example.flickrsearch.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class FlickrImage(
    @SerializedName("id")
    val id: String,
    @SerializedName("secret")
    val secret: String,
    @SerializedName("server")
    val server: String
)
