package com.bankmisr.MoneyTransfareApplication.apis.signIn

import com.bankmisr.MoneyTransfareApplication.Constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object signInAPIService {

    val api: signinAPICallable by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(signinAPICallable::class.java)
    }
}