package com.arturdziombek.coffeecounter.repository.base.dao

import androidx.room.Query
import com.arturdziombek.coffeecounter.repository.models.Authentication
import io.reactivex.Single

@androidx.room.Dao
interface AuthenticationDao : Dao<Authentication> {
  @Query("select * from Authentication LIMIT 1")
  fun getAuthToken(): Single<Authentication>
}