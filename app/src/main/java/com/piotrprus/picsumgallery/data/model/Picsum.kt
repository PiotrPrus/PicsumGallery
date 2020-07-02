package com.piotrprus.picsumgallery.data.model

import com.google.gson.annotations.SerializedName

// Data structure from https://picsum.photos/v2/list
//{
//    "id": "0",
//    "author": "Alejandro Escamilla",
//    "width": 5616,
//    "height": 3744,
//    "url": "https://unsplash.com/...",
//    "download_url": "https://picsum.photos/..."
//}

data class Picsum(
    val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    @SerializedName("download_url") val downloadUrl: String
)