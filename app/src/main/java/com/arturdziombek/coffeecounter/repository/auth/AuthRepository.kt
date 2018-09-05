package com.arturdziombek.coffeecounter.repository.auth

import io.reactivex.Completable

interface AuthRepository {
  fun login(login: String, password: String): Completable
  fun signUp(login: String, password: String): Completable
}