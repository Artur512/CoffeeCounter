package com.arturdziombek.coffeecounter.ui.base.activity

import android.app.Dialog
import android.app.Fragment
import android.app.ProgressDialog


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


import androidx.lifecycle.LifecycleRegistry
import com.arturdziombek.coffeecounter.utils.observe
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.contentView
import javax.inject.Inject

abstract class BaseActivity<out VM : BaseViewModel> : AppCompatActivity(), HasFragmentInjector {
  @Inject
  lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

  override fun fragmentInjector(): AndroidInjector<Fragment> {
    return fragmentInjector
  }

  abstract val layout: Int

  val disposables = CompositeDisposable()
  abstract val viewModel: VM
  protected val mRegistry = LifecycleRegistry(this)
  override fun getLifecycle() = mRegistry

  private val progressDialogs: MutableList<Dialog> = mutableListOf()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    AndroidInjection.inject(this)
    setContentView(layout)

  }

  override fun onStart() {
    super.onStart()
    observeError()
  }

  private fun observeError() {
    observe(viewModel.error, {
      it?.let {
        showSnackBar(it.message)
      }
    })
  }

  private fun showSnackBar(message: String) {
    val view = contentView
    view?.let {
      Snackbar.make(it, message,
          Snackbar.LENGTH_SHORT).show()
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    disposables.clear()
  }

  fun showProgressDialog(content: String) {
    //TODO
  }

}
