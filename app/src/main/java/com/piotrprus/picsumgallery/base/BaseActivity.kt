package com.piotrprus.picsumgallery.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (this::class.annotations
            .filterIsInstance(LayoutResId::class.java)
            .firstOrNull())
            ?.let {
                setContentView(it.resId)
            }
        start()
    }

    open fun start() {}

    fun <T> LiveData<T>.observe(observe: ((value: T?) -> Unit)) {
        this.observe(this@BaseActivity, Observer { value -> observe(value) })
    }
}