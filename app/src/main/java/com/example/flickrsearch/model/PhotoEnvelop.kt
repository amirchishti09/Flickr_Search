package com.example.flickrsearch.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoEnvelop(
    @SerialName("photos")
    val photos: List<FlickrImage>
)
