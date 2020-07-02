package com.piotrprus.picsumgallery.feature.detail

import com.piotrprus.picsumgallery.R
import com.piotrprus.picsumgallery.base.BaseFragment
import com.piotrprus.picsumgallery.base.LayoutResId
import org.koin.android.viewmodel.ext.android.viewModel

@LayoutResId(R.layout.fragment_detail)
class DetailFragment : BaseFragment() {

    private val viewModel : DetailViewModel by viewModel()

    override fun start() {
        super.start()
    }

}