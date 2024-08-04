package com.bankmisr.MoneyTransfareApplication.models

import com.bankmisr.MoneyTransfareApplication.Constants.Constants
import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName(Constants.EMAIL_KEY)
    val email: String,
    @SerializedName(Constants.PASSWORD_KEY)
    val password: String
)

data class LoginResponse(
    @SerializedName(Constants.TOKEN_KEY)
    val token: String,
    @SerializedName(Constants.TOKEN_TYPE_KEY)
    val tokenType: String,
    @SerializedName(Constants.MESSAGE_KEY)
    val message: String,
    @SerializedName(Constants.STATUS_CODE_KEY)
    val statusCode: String
)
