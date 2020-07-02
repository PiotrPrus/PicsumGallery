package com.piotrprus.picsumgallery.common.di

import com.piotrprus.picsumgallery.data.repository.PicsumRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { PicsumRepository(get()) }
}