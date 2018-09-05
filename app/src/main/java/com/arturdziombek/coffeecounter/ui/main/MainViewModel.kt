package com.arturdziombek.coffeecounter.ui.main

import androidx.lifecycle.MutableLiveData
import com.arturdziombek.coffeecounter.commons.error.ErrorResolver
import com.arturdziombek.coffeecounter.domain.main.MainUseCase
import com.arturdziombek.coffeecounter.ui.base.activity.BaseViewModel
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MainViewModel @Inject constructor(errorResolver: ErrorResolver,
    private val useCase: MainUseCase) : BaseViewModel(errorResolver) {
  val dynamicLinkPath = MutableLiveData<String>()
  fun observeDynamicLink() {
    useCase.observeDynamicLink()
        .subscribeBy(onError = {
          onError(it)
        }, onSuccess = {
          dynamicLinkPath.value = it
        }).addTo(disposables)
  }

}


