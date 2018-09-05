package com.arturdziombek.coffeecounter.domain.auth

import com.arturdziombek.coffeecounter.repository.auth.AuthRepository
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AuthUseCaseImplTest {
  @Mock
  private
  lateinit var repository: AuthRepository

  @InjectMocks
  private
  lateinit var useCase: AuthUseCaseImpl

  @Before
  fun setUp() {
    given(repository.signUp("login", "password")).willReturn(Completable.complete())
    given(repository.login("login", "password")).willReturn(Completable.complete())
  }

  @Test
  fun when_is_calling_login_method_should_call_repository() {
    useCase.login("login", "password", Schedulers.trampoline(), Schedulers.trampoline())
    verify(repository).login("login", "password")
  }

  @Test
  fun when_signup_with_login_and_password_return_completable() {
    useCase.signUp("login", "password", Schedulers.trampoline(), Schedulers.trampoline())
        .test()
        .assertComplete()
  }
}