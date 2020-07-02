package com.piotrprus.picsumgallery.feature.gallery

import com.piotrprus.picsumgallery.R
import com.piotrprus.picsumgallery.base.BaseFragment
import com.piotrprus.picsumgallery.base.LayoutResId
import org.koin.android.viewmodel.ext.android.viewModel

@LayoutResId(R.layout.fragment_gallery)
class GalleryFragment : BaseFragment() {

    private val viewModel: GalleryViewModel by viewModel()

    override fun start() {
        super.start()
    }
}