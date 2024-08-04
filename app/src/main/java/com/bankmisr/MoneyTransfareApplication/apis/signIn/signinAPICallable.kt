package com.bankmisr.MoneyTransfareApplication.apis.signIn

import com.bankmisr.MoneyTransfareApplication.Constants.Constants
import com.bankmisr.MoneyTransfareApplication.models.LoginRequest
import com.bankmisr.MoneyTransfareApplication.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface signinAPICallable {

    @POST(Constants.LOGIN_ENDPOINT)
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>


}