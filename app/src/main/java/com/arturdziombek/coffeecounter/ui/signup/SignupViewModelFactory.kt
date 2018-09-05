package com.arturdziombek.coffeecounter.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import javax.inject.Inject

class SignupViewModelFactory @Inject constructor(
    val viewModel: SignupViewModel) : Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(SignupViewModel::class.java)) {
      return viewModel as T
    }
    throw IllegalArgumentException("Unknown class name")
  }
}