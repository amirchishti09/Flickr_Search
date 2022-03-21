package com.example.flickrsearch.data.remote

import com.example.flickrsearch.model.PhotoEnvelop
import com.example.flickrsearch.util.Constants.FLICKR_API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {
    @GET("https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=$FLICKR_API_KEY&format=json&nojsoncallback=1")
    suspend fun searchPhotos(
        @Query(value = "text", encoded = true) input: String
    ): PhotoEnvelop
}