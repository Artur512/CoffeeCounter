package com.arturdziombek.coffeecounter.repository.data

import com.arturdziombek.coffeecounter.repository.models.Authentication
import com.arturdziombek.coffeecounter.repository.models.SignUpRequest
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface RemoteRepository {

  @POST("/oauth/token")
  fun login(login: String, password: String): Single<Authentication>

  @POST("/coffeeDrinkers")
  fun signUp(@Body request: SignUpRequest): Single<Authentication>
}