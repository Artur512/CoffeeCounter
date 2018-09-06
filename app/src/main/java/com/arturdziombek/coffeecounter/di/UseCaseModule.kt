package com.arturdziombek.coffeecounter.di

import com.arturdziombek.coffeecounter.domain.auth.AuthUseCase
import com.arturdziombek.coffeecounter.domain.auth.AuthUseCaseImpl
import com.arturdziombek.coffeecounter.domain.main.MainUseCase
import com.arturdziombek.coffeecounter.domain.main.MainUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {
  @Binds
  abstract fun provideAuthUseCase(usecase: AuthUseCaseImpl): AuthUseCase

  @Binds
  abstract fun provideMainUseCsae(useCase: MainUseCaseImpl): MainUseCase

}