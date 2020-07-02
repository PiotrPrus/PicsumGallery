package com.piotrprus.picsumgallery.data.api

import com.piotrprus.picsumgallery.data.model.Picsum
import retrofit2.http.GET
import retrofit2.http.Query

interface LoremPicsumApi {

    @GET("v2/list")
    suspend fun getPicsumList(
        @Query("page") pageNumber: Int
    ): List<Picsum>
}