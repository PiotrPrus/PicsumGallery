package com.piotrprus.picsumgallery.common.di

import com.piotrprus.picsumgallery.feature.main.MainSharedViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainSharedViewModel() }
}