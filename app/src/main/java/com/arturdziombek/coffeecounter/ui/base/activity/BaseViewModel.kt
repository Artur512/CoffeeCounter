package com.arturdziombek.coffeecounter.ui.base.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arturdziombek.coffeecounter.commons.error.ErrorResolver
import com.arturdziombek.coffeecounter.repository.models.ErrorData
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(private val errorResolver: ErrorResolver

) : ViewModel(

) {

  val inProgress = MutableLiveData<Boolean>()
  val disposables = CompositeDisposable()
  val message = MutableLiveData<String>()
  val unAuthorized = MutableLiveData<Boolean>()
  val error = MutableLiveData<ErrorData>()
  open fun onError(throwable: Throwable) {
    val errorData = errorResolver.resolveError(throwable)
    if (errorData.unauthorized) {
      unAuthorized.value = true
    } else {
      handleError(errorData)
    }
  }

  open fun handleError(errorData: ErrorData) {
    error.value = errorData
    error.value = null
  }
}