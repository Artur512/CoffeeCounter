package com.arturdziombek.coffeecounter.ui.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.afollestad.materialdialogs.MaterialDialog
import com.arturdziombek.coffeecounter.ui.base.activity.BaseViewModel
import com.arturdziombek.coffeecounter.utils.observeLiveData
import com.google.android.material.snackbar.Snackbar
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.contentView

abstract class BaseFragment<out VM : BaseViewModel> : androidx.fragment.app.Fragment(), LifecycleOwner {
  abstract val layout: Int
  abstract val viewModel: VM
  val disposables = CompositeDisposable()
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    return inflater.inflate(layout, null)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    observeErrors()
    observeMessages()
    observeProgress()
    observeUnAuthorizedStatus()
    bindClicks()
  }


  private fun observeErrors() {
    viewModel.error.observe(this, Observer { error ->
      error?.let { er ->
        view?.let {
          Snackbar.make(it, er.message,
              Snackbar.LENGTH_SHORT).show()
        }
      }

    })
  }


  private fun observeMessages() {
    observeLiveData(viewModel.message, { message ->

      val view = activity?.contentView
      view?.let {
        Snackbar.make(view, message,
            Snackbar.LENGTH_SHORT).show()
      }
      viewModel.message.value = null
    })
  }

  private fun observeProgress() {
    observeLiveData(viewModel.inProgress, {
      //      if (it)
//        progressDialog?.show()
//      else
//        progressDialog?.hide()

    })
  }

  private fun observeUnAuthorizedStatus() {
    observeLiveData(viewModel.unAuthorized, {
      //  if (it)
      //showFragment(LoginFragment(), false)

    })
  }

  protected open fun bindClicks() {}

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    // callback = context as BaseContract.ActivityListener
  }

  protected fun showDialog(
      title: String = "",
      message: String = "",
      positive: String = "",
      positiveAction: () -> Unit = {},
      negative: String = "",
      negativeAction: () -> Unit = {},
      neutral: String = "",
      neutralAction: () -> Unit = {},
      cancelAction: () -> Unit = {},
      dismissAction: () -> Unit = {}) {
    val dialogBuilder = MaterialDialog.Builder(context!!)

    if (title.isNotBlank()) {
      dialogBuilder.title(title)
    }

    if (message.isNotBlank()) {
      dialogBuilder.content(message)
    }

    if (positive.isNotBlank()) {
      dialogBuilder.positiveText(positive)
      dialogBuilder.onPositive { _, _ -> positiveAction() }
    }

    if (negative.isNotBlank()) {
      dialogBuilder.negativeText(negative)
      dialogBuilder.onNegative { _, _ -> negativeAction() }
    }

    if (neutral.isNotBlank()) {
      dialogBuilder.neutralText(positive)
      dialogBuilder.onNeutral { _, _ -> neutralAction() }
    }
    //  dialogBuilder.positiveColorRes(R.color.primary)
    dialogBuilder.cancelListener { cancelAction() }
    dialogBuilder.dismissListener { dismissAction() }

    val dialog = dialogBuilder.build()
    dialog.show()
  }

}



