package com.arturdziombek.coffeecounter.domain.auth

import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.Android

interface AuthUseCase {
  fun login(login: String, password: String,
      observeScheduler: Scheduler = AndroidSchedulers.mainThread(),
      subscribeScheduler: Scheduler = Schedulers.io()): Completable

  fun signUp(login: String, password: String,
      observeScheduler: Scheduler = AndroidSchedulers.mainThread(),
      subscribeScheduler: Scheduler = Schedulers.io()): Completable
}