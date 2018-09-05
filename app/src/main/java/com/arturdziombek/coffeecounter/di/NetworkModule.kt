package com.arturdziombek.coffeecounter.di

import com.arturdziombek.coffeecounter.commons.AuthInterceptor
import com.arturdziombek.coffeecounter.repository.base.dao.AuthenticationDao
import com.arturdziombek.coffeecounter.repository.data.RemoteRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

  @Provides
  @Singleton
  fun providePostApi(retrofit: Retrofit): RemoteRepository {
    return retrofit.create(RemoteRepository::class.java)
  }

  @Provides
  @Singleton
  fun provideRetrofitInterface(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("http://www.example.pl")
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
  }

  @Provides
  @Singleton
  fun provideOkHttpClient(authenticationDao: AuthenticationDao): OkHttpClient {
    return OkHttpClient().newBuilder()
        .addInterceptor(AuthInterceptor(authenticationDao))
        .build()
  }
}