package com.example.flickrsearch.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoEnvelop(
    @SerialName("photos")
    val photos: Photos
)

@Serializable

data class Photos(
    @SerialName("page")
    val page: Int,
    @SerialName("pages")
    val totalPages: Int,
    @SerialName("perpage")
    val perPage: Int,
    @SerialName("total")
    val total: Int,
    @SerialName("photo")
    val images: List<FlickrImage>
)