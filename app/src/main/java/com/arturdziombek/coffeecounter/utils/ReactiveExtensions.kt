package com.arturdziombek.coffeecounter.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

fun <T> LifecycleOwner.observeLiveData(liveData: LiveData<T>, observer: (T) -> Unit) {
  liveData.observe(this, Observer {
    it?.let(observer)
  })
}

operator fun <T> MutableLiveData<MutableList<T>>.plusAssign(values: MutableList<T>) {
  val value = this.value ?: arrayListOf()
  value.addAll(values)
  this.value = value
}


fun <T> MutableLiveData<MutableList<T>>.liveAdd(value: T) {
  val list = this.value ?: mutableListOf<T>()
  list.add(value)
  this.value = list
}

fun <T> MutableLiveData<MutableList<T>>.liveRemove(value: T) {
  val list = this.value ?: mutableListOf<T>()
  list.remove(value)
  this.value = list
}

fun <T> MutableLiveData<MutableList<T>>.liveRemove(index: Int) {
  val list = this.value ?: mutableListOf<T>()
  list.removeAt(index)
  this.value = list
}

fun <T> MutableLiveData<MutableList<T>>.liveSet(index: Int, value: T) {
  val list = this.value ?: mutableListOf<T>()
  list[index] = value
  this.value = list
}

fun <T> MutableLiveData<MutableList<T>>.liveReplace(index: Int, value: T) {
  val list = this.value ?: mutableListOf<T>()
  list[index] = value
  this.value = list
}