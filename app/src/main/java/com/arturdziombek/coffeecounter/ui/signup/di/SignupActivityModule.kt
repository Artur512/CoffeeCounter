package com.arturdziombek.coffeecounter.ui.signup.di

import androidx.lifecycle.ViewModelProvider
import com.arturdziombek.coffeecounter.di.scope.ActivityScoped
import com.arturdziombek.coffeecounter.ui.signup.SignupActivity
import com.arturdziombek.coffeecounter.ui.signup.SignupViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class SignupActivityModule {
  @Binds
  @ActivityScoped
  abstract fun provideViewModelFactory(
      factory: SignupViewModelFactory): ViewModelProvider.Factory
}