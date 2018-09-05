package com.arturdziombek.coffeecounter.domain.main

import com.arturdziombek.coffeecounter.repository.auth.AuthRepository
import com.arturdziombek.coffeecounter.repository.link.DynamicLinkRepository
import io.reactivex.Maybe
import io.reactivex.Scheduler
import javax.inject.Inject

class MainUseCaseImpl @Inject constructor(private val repository: DynamicLinkRepository) : MainUseCase {
  override fun observeDynamicLink(observeScheduler: Scheduler,
      subscribeScheduler: Scheduler): Maybe<String> {
    return repository.observeDynamicFink()
  }
}