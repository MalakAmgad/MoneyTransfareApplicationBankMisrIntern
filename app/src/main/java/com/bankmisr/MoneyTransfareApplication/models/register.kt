package com.bankmisr.MoneyTransfareApplication.models

import com.bankmisr.MoneyTransfareApplication.Constants.Constants
import com.google.gson.annotations.SerializedName

data class register(

    @SerializedName(Constants.REGISTER_FIRST_NAME)
    val firstName: String,
    @SerializedName(Constants.REGISTER_LAST_NAME)
    val lastName: String,
    @SerializedName(Constants.REGISTER_GENDER)
    val gender: String,@SerializedName(Constants.REGISTER_EMAIL)
    val email: String,
    @SerializedName(Constants.REGISTER_PHONE_NUMBER)
    val phoneNumber: String,
    @SerializedName(Constants.REGISTER_ADDRESS)
    val address: String,
    @SerializedName(Constants.REGISTER_NATIONALITY)
    val nationality: String,
    @SerializedName(Constants.REGISTER_NATIONAL_NUMBER)
    val nationalNumber: String,
    @SerializedName(Constants.REGISTER_DATE_OF_BIRTH)
    val dateOfBirth: String,
    @SerializedName(Constants.REGISTER_PASSWORD)
    val password: String

        )