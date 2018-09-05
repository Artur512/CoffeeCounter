package com.arturdziombek.coffeecounter.commons.error

import com.arturdziombek.coffeecounter.repository.models.ErrorData

interface ErrorResolver {

  fun resolveError(throwable: Throwable): ErrorData
}