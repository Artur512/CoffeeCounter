package com.arturdziombek.coffeecounter.ui.login

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.arturdziombek.coffeecounter.R
import com.arturdziombek.coffeecounter.ui.base.activity.BaseActivity
import com.arturdziombek.coffeecounter.ui.main.MainActivity
import com.arturdziombek.coffeecounter.ui.signup.SignupActivity
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_login.btn_login
import kotlinx.android.synthetic.main.activity_login.logoImage
import kotlinx.android.synthetic.main.activity_login.signUp
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class LoginActivity : BaseActivity<LoginViewModel>() {
  @Inject
  lateinit var factory: LoginViewModelFactory
  override lateinit var viewModel: LoginViewModel

  override val layout: Int
    get() = R.layout.activity_login


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = ViewModelProviders.of(this, factory).get(
        LoginViewModel::class.java)
    bindClicks()
    Glide.with(this)
        .load(
            "https://78.media.tumblr.com/389eab7635fa3a13d04cb945e1974a73/tumblr_ml5xhbUWC21qg6rkio1_500.gif")
        .into(logoImage)

  }

  private fun bindClicks() {
    RxView.clicks(btn_login)
        .subscribeBy {
          startActivity<MainActivity>()
        }.addTo(disposables)
    RxView.clicks(signUp)
        .subscribeBy {
          startActivity<SignupActivity>()
        }.addTo(disposables)
  }
}
