package com.arturdziombek.coffeecounter.utils

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun View.visible() {
  visibility = View.VISIBLE
}

fun View.gone() {
  visibility = View.GONE
}

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
  liveData.observe(this, Observer(body))
}