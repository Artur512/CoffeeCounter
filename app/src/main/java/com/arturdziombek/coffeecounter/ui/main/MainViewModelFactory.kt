package com.arturdziombek.coffeecounter.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    val viewModel: MainViewModel) : Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
      return viewModel as T
    }
    throw IllegalArgumentException("Unknown class name")
  }
}