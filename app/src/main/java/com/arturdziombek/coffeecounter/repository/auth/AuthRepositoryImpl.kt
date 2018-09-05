package com.arturdziombek.coffeecounter.repository.auth

import com.arturdziombek.coffeecounter.repository.base.dao.AuthenticationDao
import com.arturdziombek.coffeecounter.repository.data.RemoteRepository
import io.reactivex.Completable
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val api: RemoteRepository,
    private val dao: AuthenticationDao) : AuthRepository {
  override fun signUp(login: String, password: String): Completable {
    return Completable.complete()
  }
    override fun login(login: String, password: String): Completable {
      return Completable.complete()
    }

  }