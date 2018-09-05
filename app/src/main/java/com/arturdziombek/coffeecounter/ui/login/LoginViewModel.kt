package com.arturdziombek.coffeecounter.ui.login

import androidx.lifecycle.MutableLiveData
import com.arturdziombek.coffeecounter.commons.error.ErrorResolver
import com.arturdziombek.coffeecounter.domain.auth.AuthUseCase
import com.arturdziombek.coffeecounter.ui.base.activity.BaseViewModel
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class LoginViewModel @Inject constructor(errorResolver: ErrorResolver,
    private val useCase: AuthUseCase) : BaseViewModel(errorResolver) {

  val logged = MutableLiveData<Boolean>()
  fun login(login: String, password: String) {
    useCase.login(login, password)
        .subscribeBy({
          onError(it)
        }, {
          logged.value = true
        }).addTo(disposables)
  }

}



