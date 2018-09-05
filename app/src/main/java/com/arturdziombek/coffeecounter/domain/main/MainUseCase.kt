package com.arturdziombek.coffeecounter.domain.main

import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface MainUseCase {
  fun observeDynamicLink(observeScheduler: Scheduler = AndroidSchedulers.mainThread(),
      subscribeScheduler: Scheduler = Schedulers.io()): Maybe<String>
}