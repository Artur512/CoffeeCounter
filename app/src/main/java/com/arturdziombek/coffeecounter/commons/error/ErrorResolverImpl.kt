package com.arturdziombek.coffeecounter.commons.error

import com.arturdziombek.coffeecounter.repository.models.ErrorData
import javax.inject.Inject

class ErrorResolverImpl @Inject constructor() : ErrorResolver {
  override fun resolveError(throwable: Throwable): ErrorData {

    //todo handle throwable type
    return ErrorData(throwable.localizedMessage)
  }

}