package com.bankmisr.MoneyTransfareApplication.apis.Transaction

import com.bankmisr.MoneyTransfareApplication.Constants.Constants
import com.bankmisr.MoneyTransfareApplication.models.Account
import com.bankmisr.MoneyTransfareApplication.models.Transaction
import com.bankmisr.MoneyTransfareApplication.models.TransferRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TransactionAPICallable {
    @POST(Constants.TRANSFER_ENDPOINT)
    suspend fun transferMoney(@Body transferRequest: TransferRequest): Response<Transaction>
/*
    @GET("${Constants.TRANSACTIONS_ENDPOINT}/account/{accountId}")
    suspend fun getAccountDetails(@Path("accountId") accountId: Int): Response<Account>
*/
    @GET(Constants.TRANSACTIONS_ENDPOINT)
    suspend fun getAllTransactions(): Response<List<Transaction>>

    @GET("${Constants.TRANSACTIONS_ENDPOINT}/{id}")
    suspend fun getTransaction(@Path("id") transactionId: Int): Response<Transaction>

    @GET("${Constants.TRANSACTIONS_ENDPOINT}/account/{accountId}")
    suspend fun getTransactionsByAccount(@Path("accountId") accountId: Int): Response<List<Transaction>>

    @DELETE("${Constants.TRANSACTIONS_ENDPOINT}/{id}")
    suspend fun deleteTransaction(@Path("id") transactionId: Int): Response<Unit>
}
