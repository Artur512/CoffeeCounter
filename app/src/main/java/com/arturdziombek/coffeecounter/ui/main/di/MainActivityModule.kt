package com.arturdziombek.coffeecounter.ui.main.di

import androidx.lifecycle.ViewModelProvider
import com.arturdziombek.coffeecounter.di.scope.ActivityScoped
import com.arturdziombek.coffeecounter.ui.main.MainViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityModule {
  @Binds
  @ActivityScoped
  abstract fun provideViewModelFactory(
      factory: MainViewModelFactory): ViewModelProvider.Factory
}