package com.arturdziombek.coffeecounter.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arturdziombek.coffeecounter.repository.base.dao.AuthenticationDao
import com.arturdziombek.coffeecounter.repository.base.dao.CoffeeCounterDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
  @Provides
  @Singleton
  fun provideDatabase(app: Application): CoffeeCounterDatabase = Room.databaseBuilder(app,
      CoffeeCounterDatabase::class.java, "SimpleDb").build()

  @Provides
  @Singleton
  fun provideAuthenticationDao(database: CoffeeCounterDatabase): AuthenticationDao {
    return database.authenticationDao()
  }
}

