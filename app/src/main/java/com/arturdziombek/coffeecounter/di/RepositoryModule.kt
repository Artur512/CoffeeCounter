package com.arturdziombek.coffeecounter.di

import com.arturdziombek.coffeecounter.repository.auth.AuthRepository
import com.arturdziombek.coffeecounter.repository.auth.AuthRepositoryImpl
import com.arturdziombek.coffeecounter.repository.link.DynamicLinkRepository
import com.arturdziombek.coffeecounter.repository.link.DynamicLinkRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
  @Binds
  abstract fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
  @Binds
  abstract fun provideDynamicLinkRepository(authRepositoryImpl: DynamicLinkRepositoryImpl): DynamicLinkRepository
}