package com.bankmisr.MoneyTransfareApplication.apis.register

import com.bankmisr.MoneyTransfareApplication.Constants.Constants
import com.bankmisr.MoneyTransfareApplication.models.register
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface registerAPICallable {
    @POST(Constants.REGISTER_ENDPOINT)
    suspend fun registerUser(@Body register: register): Response<register>

}