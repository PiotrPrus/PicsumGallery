package com.piotrprus.picsumgallery.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

abstract class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (this::class.annotations
            .filterIsInstance(LayoutResId::class.java)
            .firstOrNull())
            ?.let {
                val view = inflater.inflate(it.resId, container, false)
            }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        start()
    }

    open fun start() {}

    fun <T> LiveData<T>.observe(observe: ((value: T?) -> Unit)) {
        this.observe(this@BaseFragment, Observer { value -> observe(value) })
    }
}