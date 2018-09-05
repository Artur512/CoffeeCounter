package com.arturdziombek.coffeecounter.repository.base.dao

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update



interface Dao<T>{

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(obj: T)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(vararg obj: T)

  @Update
  fun update(obj: T)

  @Delete
  fun delete(obj: T)
}