package com.example.flickrsearch.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.flickrsearch.data.paging.SearchPagingSource
import com.example.flickrsearch.data.remote.FlickrApi
import com.example.flickrsearch.model.FlickrImage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class Repository @Inject constructor(
    private val flickrApi: FlickrApi
) {
    fun searchImages(query: String): Flow<PagingData<FlickrImage>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchPagingSource(flickrApi, query)
            }
        ).flow
    }

}