package com.arturdziombek.coffeecounter.repository.models

data class SignUpRequest(
    var login: String = "",
    var password: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var email: String = ""

)