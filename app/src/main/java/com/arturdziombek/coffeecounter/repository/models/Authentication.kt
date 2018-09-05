package com.arturdziombek.coffeecounter.repository.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class Authentication(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @SerializedName("access_token")
    var accessToken: String = "",

    @SerializedName("token_type")
    var tokenType: String = "",

    @SerializedName("refresh_token")
    var refreshToken: String = "",

    @SerializedName("expires_in")
    var expiresIn: Long = 0,

    @SerializedName("scope")
    var scope: String = "",

    @SerializedName("jti")
    var jti: String = ""
)