package com.piotrprus.picsumgallery.data.repository

import com.piotrprus.picsumgallery.data.api.LoremPicsumApi

class PicsumRepository(private val loremPicsumApi: LoremPicsumApi) {
    suspend fun getPictures() = loremPicsumApi.getPicsumList()
}