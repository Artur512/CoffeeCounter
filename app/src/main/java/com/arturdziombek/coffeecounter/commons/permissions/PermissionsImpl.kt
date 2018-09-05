package com.arturdziombek.coffeecounter.commons.permissions

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable

class PermissionsImpl(val activityCreator: () -> AppCompatActivity) : Permissions {
    override fun sendRequestToReadExternalStorage(): Observable<Boolean> {
        return RxPermissions(activityCreator()).request(Manifest.permission.READ_EXTERNAL_STORAGE)
    }

}