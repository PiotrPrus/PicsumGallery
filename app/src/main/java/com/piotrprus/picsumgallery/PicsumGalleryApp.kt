package com.piotrprus.picsumgallery

import android.app.Application
import com.piotrprus.picsumgallery.common.di.networkModule
import com.piotrprus.picsumgallery.common.di.repositoryModule
import com.piotrprus.picsumgallery.common.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class PicsumGalleryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PicsumGalleryApp)
            modules(
                viewModelModule, networkModule, repositoryModule
            )
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}