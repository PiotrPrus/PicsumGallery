package com.piotrprus.picsumgallery.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.piotrprus.picsumgallery.data.api.LoremPicsumApi
import com.piotrprus.picsumgallery.data.datasource.PicsumDataSource
import com.piotrprus.picsumgallery.data.model.Picsum
import kotlinx.coroutines.flow.Flow

class PicsumRepository(private val loremPicsumApi: LoremPicsumApi) {
    fun getPicturesStream(): Flow<PagingData<Picsum>> {
        return Pager(
            config = PagingConfig(pageSize = 30),
            pagingSourceFactory = { PicsumDataSource(loremPicsumApi) }
        ).flow
    }
}