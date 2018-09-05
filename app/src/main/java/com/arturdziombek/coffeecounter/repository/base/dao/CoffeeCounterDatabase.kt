package com.arturdziombek.coffeecounter.repository.base.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arturdziombek.coffeecounter.repository.models.Authentication

@Database(entities = [
  Authentication::class
], version = 1, exportSchema = false)
abstract class CoffeeCounterDatabase : RoomDatabase() {

  abstract fun authenticationDao(): AuthenticationDao
}