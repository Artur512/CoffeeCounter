package com.arturdziombek.coffeecounter.ui.main

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.arturdziombek.coffeecounter.R
import com.arturdziombek.coffeecounter.ui.base.activity.BaseActivity
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.coffeeButton
import javax.inject.Inject
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.dynamiclinks.PendingDynamicLinkData
import com.google.android.gms.tasks.OnSuccessListener
import java.nio.file.Files.createLink
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.arturdziombek.coffeecounter.utils.observe
import com.google.firebase.dynamiclinks.DynamicLink.AndroidParameters
import kotlinx.android.synthetic.main.activity_main.link


class MainActivity : BaseActivity<MainViewModel>() {
  @Inject
  lateinit var factory: MainViewModelFactory
  override lateinit var viewModel: MainViewModel

  override val layout: Int
    get() = R.layout.activity_main
  override fun onResume() {
    super.onResume()
    viewModel.observeDynamicLink()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    bindClicks()
    viewModel = ViewModelProviders.of(this, factory).get(
        MainViewModel::class.java)

    observeDynamicLink()

  }

  private fun bindClicks() {
    RxView.clicks(coffeeButton)
        .subscribeBy {

        }.addTo(disposables)
  }

  private fun observeDynamicLink() {
    observe(viewModel.dynamicLinkPath, {
      link.text = "Dynamic link from ${it?.trimStart { it == '/' }}"
    })

  }
}
