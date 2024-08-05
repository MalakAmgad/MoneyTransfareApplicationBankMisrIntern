package com.bankmisr.MoneyTransfareApplication.apis.Transaction

import com.bankmisr.MoneyTransfareApplication.Constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TransactionAPIService {
    val api: TransactionAPICallable by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TransactionAPICallable::class.java)
    }
}