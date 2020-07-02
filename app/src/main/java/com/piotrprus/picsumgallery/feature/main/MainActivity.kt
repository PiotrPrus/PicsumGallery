package com.piotrprus.picsumgallery.feature.main

import com.piotrprus.picsumgallery.R
import com.piotrprus.picsumgallery.base.BaseActivity
import com.piotrprus.picsumgallery.base.LayoutResId
import org.koin.android.viewmodel.ext.android.viewModel

@LayoutResId(R.layout.activity_main)
class MainActivity : BaseActivity() {

    private val viewModel: MainSharedViewModel by viewModel()

    override fun start() {
        super.start()
    }
}