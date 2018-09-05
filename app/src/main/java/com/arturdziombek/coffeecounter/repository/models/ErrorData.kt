package com.arturdziombek.coffeecounter.repository.models

data class ErrorData(var message: String = "",
    var code: Int = 0,
    var unauthorized: Boolean = false)