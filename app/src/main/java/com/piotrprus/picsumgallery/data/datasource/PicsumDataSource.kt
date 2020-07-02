package com.piotrprus.picsumgallery.data.datasource

import androidx.paging.PagingSource
import com.piotrprus.picsumgallery.data.api.LoremPicsumApi
import com.piotrprus.picsumgallery.data.model.Picsum
import okio.IOException
import retrofit2.HttpException

private const val PICSUM_STARTING_PAGE_INDEX = 1

class PicsumDataSource(private val api: LoremPicsumApi) : PagingSource<Int, Picsum>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Picsum> {
        val position = params.key ?: PICSUM_STARTING_PAGE_INDEX
        return try {
            val response = api.getPicsumList(position)
            LoadResult.Page(
                data = response,
                prevKey = if (position == PICSUM_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (response.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}