package com.arturdziombek.coffeecounter.ui.login.di

import androidx.lifecycle.ViewModelProvider
import com.arturdziombek.coffeecounter.di.scope.ActivityScoped
import com.arturdziombek.coffeecounter.ui.login.LoginViewModelFactory
import dagger.Binds
import dagger.Module


@Module
abstract class LoginActivityModule {

    @Binds
    @ActivityScoped
    abstract fun provideViewModelFactory(
        factory: LoginViewModelFactory): ViewModelProvider.Factory
}