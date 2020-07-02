package com.piotrprus.picsumgallery.feature.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piotrprus.picsumgallery.data.model.Picsum
import com.piotrprus.picsumgallery.data.repository.PicsumRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class GalleryViewModel(private val ipsumRepository: PicsumRepository) : ViewModel() {

    private val _pictures = MutableLiveData<List<Picsum>>()
    val pictures: LiveData<List<Picsum>>
        get() = _pictures
    private val _loadingVisibility = MutableLiveData<Boolean>()
    val loadingVisibility: LiveData<Boolean>
    get() = _loadingVisibility

    init {
        fetchIpsumImages()
    }

    private fun fetchIpsumImages() {
        viewModelScope.launch {
            try {
                _loadingVisibility.postValue(true)
                val list = ipsumRepository.getPictures()
                _pictures.postValue(list)
                _loadingVisibility.postValue(false)
            } catch (e: Exception) {
                Timber.w("Failed to fetch pictures")
                _loadingVisibility.postValue(false)
            }
        }
    }
}