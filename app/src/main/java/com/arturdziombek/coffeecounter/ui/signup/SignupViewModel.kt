package com.arturdziombek.coffeecounter.ui.signup

import androidx.lifecycle.MutableLiveData
import com.arturdziombek.coffeecounter.commons.error.ErrorResolver
import com.arturdziombek.coffeecounter.domain.auth.AuthUseCase
import com.arturdziombek.coffeecounter.ui.base.activity.BaseViewModel
import javax.inject.Inject

class SignupViewModel @Inject constructor(errorResolver: ErrorResolver,
    private val useCase: AuthUseCase) : BaseViewModel(errorResolver) {
  val login = MutableLiveData<String>()
  val password = MutableLiveData<String>()

  fun signUp() {

  }
}


