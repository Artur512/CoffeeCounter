package com.arturdziombek.coffeecounter.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import javax.inject.Inject

class LoginViewModelFactory @Inject constructor(val viewModel: LoginViewModel) : Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
      return viewModel as T
    }
    throw IllegalArgumentException("Unknown class name")
  }
}