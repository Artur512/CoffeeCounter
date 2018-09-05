package com.arturdziombek.coffeecounter.commons

import com.arturdziombek.coffeecounter.repository.base.dao.AuthenticationDao
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class AuthInterceptor(private val authenticationDao: AuthenticationDao) : Interceptor {
  override fun intercept(chain: Chain): Response {

    val orginalRequest = chain.request()
    val authRequest = orginalRequest.newBuilder()

    if (orginalRequest.header(AUTH_HEADER) == null) {
//            if (secret == null)
//                authRequest.addHeader(AUTH_HEADER, "")
//            else
//                authRequest.addHeader(AUTH_HEADER, secret)
      authRequest.apply {

      }

    }

    return chain.proceed(authRequest.build())
  }

  companion object {
    const val AUTH_HEADER = ""
  }

}