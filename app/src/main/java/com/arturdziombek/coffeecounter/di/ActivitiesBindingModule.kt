package com.arturdziombek.coffeecounter.di

import com.arturdziombek.coffeecounter.di.scope.ActivityScoped
import com.arturdziombek.coffeecounter.ui.login.LoginActivity
import com.arturdziombek.coffeecounter.ui.login.di.LoginActivityModule
import com.arturdziombek.coffeecounter.ui.main.MainActivity
import com.arturdziombek.coffeecounter.ui.main.di.DynamicLinkModule
import com.arturdziombek.coffeecounter.ui.main.di.MainActivityModule
import com.arturdziombek.coffeecounter.ui.signup.SignupActivity
import com.arturdziombek.coffeecounter.ui.signup.di.SignupActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesBindingModule {
  @ActivityScoped
  @ContributesAndroidInjector(modules = [(LoginActivityModule::class)])
  abstract fun loginActivity(): LoginActivity

  @ActivityScoped
  @ContributesAndroidInjector(modules = [MainActivityModule::class, DynamicLinkModule::class])
  abstract fun mainActivity(): MainActivity

  @ActivityScoped
  @ContributesAndroidInjector(modules = [SignupActivityModule::class])
  abstract fun signupActivity(): SignupActivity
}