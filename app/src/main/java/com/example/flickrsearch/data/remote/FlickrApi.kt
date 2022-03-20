package com.example.flickrsearch.data.remote

import com.example.flickrsearch.model.FlickrImage
import com.example.flickrsearch.model.PhotoEnvelop
import com.example.flickrsearch.util.Constants.FLICKR_API_KEY
import retrofit2.http.GET
import retrofit2.http.Path

interface FlickrApi {
    @GET("/?method=flickr.photos.search&api_key={apiKey}&format=json&nojsoncallback=1&text={input}")
    suspend fun searchPhotos(
        @Path(value = "api_key", encoded = true) apiKey: String,
        @Path(value = "text", encoded = true) input: String
    ): PhotoEnvelop
}