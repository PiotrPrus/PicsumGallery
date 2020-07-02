package com.piotrprus.picsumgallery.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.piotrprus.picsumgallery.R
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainSharedViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}