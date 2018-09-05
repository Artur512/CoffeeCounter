package com.arturdziombek.coffeecounter.di

import com.arturdziombek.coffeecounter.commons.error.ErrorResolver
import com.arturdziombek.coffeecounter.commons.error.ErrorResolverImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CommonsModule {

  @Binds
  abstract fun provideErrorResolver(errorResolver: ErrorResolverImpl): ErrorResolver
}