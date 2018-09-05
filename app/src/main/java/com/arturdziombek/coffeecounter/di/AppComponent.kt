package com.arturdziombek.coffeecounter.di

import android.app.Application
import com.arturdziombek.coffeecounter.CoffeeCounterApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
      AndroidInjectionModule::class,
      AppModule::class,
      UseCaseModule::class,
      ActivitiesBindingModule::class,
      RepositoryModule::class,
      NetworkModule::class,
      DatabaseModule::class,
      CommonsModule::class
    ]
)
interface AppComponent : AndroidInjector<CoffeeCounterApplication> {
  @Component.Builder
  interface Builder {
    @BindsInstance
    fun create(app: Application): Builder

    fun build(): AppComponent
  }
}