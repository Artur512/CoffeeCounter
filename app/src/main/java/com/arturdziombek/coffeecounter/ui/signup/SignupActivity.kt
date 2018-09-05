package com.arturdziombek.coffeecounter.ui.signup

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.arturdziombek.coffeecounter.R
import com.arturdziombek.coffeecounter.ui.base.activity.BaseActivity
import com.arturdziombek.coffeecounter.ui.login.LoginViewModel
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_signup.login
import kotlinx.android.synthetic.main.activity_signup.loginET
import kotlinx.android.synthetic.main.activity_signup.passwordET
import javax.inject.Inject

class SignupActivity : BaseActivity<SignupViewModel>() {
  @Inject
  lateinit var factory: SignupViewModelFactory
  override val layout: Int
    get() = R.layout.activity_signup
  override lateinit var viewModel: SignupViewModel
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = ViewModelProviders.of(this, factory).get(SignupViewModel::class.java)
    bindClicks()
  }

  private fun bindClicks() {
    RxView.clicks(login)
        .subscribeBy {
          onBackPressed()
        }.addTo(disposables)

    RxTextView.textChanges(loginET)
        .subscribeBy {
          viewModel.login.value = it.toString()
        }.addTo(disposables)
    RxTextView.textChanges(passwordET)
        .subscribeBy {
          viewModel.password.value = it.toString()
        }.addTo(disposables)
  }
}