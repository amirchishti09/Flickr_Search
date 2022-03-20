package com.example.flickrsearch.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.flickrsearch.model.FlickrImage
import com.example.flickrsearch.data.remote.FlickrApi
import com.example.flickrsearch.util.Constants.FLICKR_API_KEY

class SearchPagingSource(
    private val flickrApi: FlickrApi,
    private val query: String
) : PagingSource<Int, FlickrImage>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FlickrImage> {
        val currentPage = params.key ?: 1
        return try {
            val response = flickrApi.searchPhotos(FLICKR_API_KEY, query)
            val endOfPaginationReached = response.photos.isEmpty()
            if (response.photos.isNotEmpty()) {
                LoadResult.Page(
                    data = response.photos,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (endOfPaginationReached) null else currentPage + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, FlickrImage>): Int? {
        return state.anchorPosition
    }
}