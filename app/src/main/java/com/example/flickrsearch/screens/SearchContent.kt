package com.example.flickrsearch.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.flickrsearch.R
import com.example.flickrsearch.model.FlickrImage
import com.example.flickrsearch.util.Constants.PHOTO_DISPLAY_BASE_URL

@ExperimentalCoilApi
@Composable
fun SearchContent(items: LazyPagingItems<FlickrImage>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = items,
            key = { flickrImage ->
                flickrImage.id
            }
        ) { flickrImage ->
            flickrImage?.let { FlickrItem(flickrImage = it) }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun FlickrItem(flickrImage: FlickrImage) {
    val painter = rememberImagePainter(data = getTargetUrl(flickrImage)) {
        crossfade(durationMillis = 1000)
        error(R.drawable.ic_image_holder)
        placeholder(R.drawable.ic_image_holder)
    }
    Box(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painter,
            contentDescription = "Flickr Image",
            contentScale = ContentScale.Crop
        )
    }
}

private fun getTargetUrl(flickrImage: FlickrImage) =
     PHOTO_DISPLAY_BASE_URL + flickrImage.server + "/" + flickrImage.id + "_" + flickrImage.secret + ".jpg"
