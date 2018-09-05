package com.arturdziombek.coffeecounter

import com.arturdziombek.coffeecounter.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class CoffeeCounterApplication : DaggerApplication(){
  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
   return DaggerAppComponent
        .builder()
        .create(this)
        .build()
  }

}