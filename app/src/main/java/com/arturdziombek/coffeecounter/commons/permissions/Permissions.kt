package com.arturdziombek.coffeecounter.commons.permissions

import io.reactivex.Observable

interface Permissions{
fun sendRequestToReadExternalStorage() : Observable<Boolean>
}