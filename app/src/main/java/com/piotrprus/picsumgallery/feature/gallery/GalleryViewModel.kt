package com.piotrprus.picsumgallery.feature.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.piotrprus.picsumgallery.data.model.Picsum
import com.piotrprus.picsumgallery.data.repository.PicsumRepository
import kotlinx.coroutines.flow.Flow

class GalleryViewModel(private val ipsumRepository: PicsumRepository) : ViewModel() {

    fun fetchData(): Flow<PagingData<Picsum>> {
        return ipsumRepository.getPicturesStream()
            .cachedIn(viewModelScope)
    }
}