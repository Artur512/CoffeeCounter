package com.arturdziombek.coffeecounter.repository.link

import android.util.Log
import com.arturdziombek.coffeecounter.R.id.link
import com.google.android.gms.tasks.Task
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.google.firebase.dynamiclinks.PendingDynamicLinkData
import io.reactivex.Maybe
import kotlinx.android.synthetic.main.activity_main.link
import javax.inject.Inject

class DynamicLinkRepositoryImpl @Inject constructor(
    private val dynamicLinkTask: Task<PendingDynamicLinkData>) : DynamicLinkRepository {
  override fun observeDynamicFink(): Maybe<String> {
    return Maybe.create { emitter ->
      dynamicLinkTask.addOnSuccessListener { result ->
        result?.link?.encodedPath?.let {
          emitter.onSuccess(it)
        }
      }.addOnFailureListener {
        emitter.onError(it)
      }
    }
  }
}


