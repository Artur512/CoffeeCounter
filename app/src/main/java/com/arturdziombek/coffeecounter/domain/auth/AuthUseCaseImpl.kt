package com.arturdziombek.coffeecounter.domain.auth

import com.arturdziombek.coffeecounter.repository.auth.AuthRepository
import io.reactivex.Completable
import io.reactivex.Scheduler
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository) : AuthUseCase {
  override fun signUp(login: String, password: String, observeScheduler: Scheduler,
      subscribeScheduler: Scheduler): Completable {
    return authRepository.signUp(login, password)
        .subscribeOn(subscribeScheduler)
        .observeOn(observeScheduler)
  }

  override fun login(login: String, password: String, observeScheduler: Scheduler,
      subscribeScheduler: Scheduler): Completable {
    return authRepository.login(login, password)
        .subscribeOn(subscribeScheduler)
        .observeOn(observeScheduler)
  }

}