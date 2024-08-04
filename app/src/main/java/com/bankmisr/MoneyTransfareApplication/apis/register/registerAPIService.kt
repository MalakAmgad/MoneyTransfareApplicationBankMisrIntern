package com.bankmisr.MoneyTransfareApplication.apis.register

import com.bankmisr.MoneyTransfareApplication.Constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object registerAPIService {

    private val retrofit= Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val callable:registerAPICallable by lazy {
        retrofit.create(registerAPICallable::class.java)
    }
}