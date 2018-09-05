package com.arturdziombek.coffeecounter.ui.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.arturdziombek.coffeecounter.commons.error.ErrorResolver
import com.arturdziombek.coffeecounter.di.UseCaseModule
import com.arturdziombek.coffeecounter.domain.auth.AuthUseCase
import com.arturdziombek.coffeecounter.repository.models.ErrorData
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import io.reactivex.android.plugins.RxAndroidPlugins
import org.junit.Rule


@RunWith(MockitoJUnitRunner::class)
class LoginViewModelTest {
  @Mock
  private lateinit var errorResolver: ErrorResolver

  @Mock
  private lateinit var useCase: AuthUseCase

  @InjectMocks
  private lateinit var viewModel: LoginViewModel

  @Rule
  @JvmField
  val rule = InstantTaskExecutorRule()

  private val error = Throwable()
  @Before
  fun setup() {
    RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> Schedulers.trampoline() }
    given(useCase.login("simpleLogin", "simpleTest")).willReturn(Completable.complete())
    given(errorResolver.resolveError(error)).willReturn(ErrorData())
  }

  @Test
  fun when_calling_login_should_run_method_from_useCase() {
    viewModel.login("simpleLogin", "simpleTest")
    verify(useCase).login("simpleLogin", "simpleTest")
  }

  @Test
  fun when_usecase_return_error_should_handle_it() {

    given(useCase.login("simpleLogin", "simpleTest")).willReturn(Completable.error(error))
    viewModel.login("simpleLogin", "simpleTest")
    verify(errorResolver).resolveError(error)
  }

  @Test
  fun when_usecase_return_complete_should_change_login_state() {
    viewModel.login("simpleLogin", "simpleTest")
    assert(viewModel.logged.value == true)
  }
}