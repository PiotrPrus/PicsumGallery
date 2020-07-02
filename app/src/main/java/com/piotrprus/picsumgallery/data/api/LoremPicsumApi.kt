package com.piotrprus.picsumgallery.data.api

import com.piotrprus.picsumgallery.data.model.Picsum
import retrofit2.http.GET

interface LoremPicsumApi {

    @GET("v2/list")
    suspend fun getPicsumList(): List<Picsum>
}