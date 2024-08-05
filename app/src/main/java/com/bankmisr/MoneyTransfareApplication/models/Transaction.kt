package com.bankmisr.MoneyTransfareApplication.models

import com.google.gson.annotations.SerializedName

data class Customer(
    @SerializedName("id") val id: Int,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("email") val email: String,
    @SerializedName("address") val address: String,
    @SerializedName("nationality") val nationality: String,
    @SerializedName("nationalIdNumber") val nationalIdNumber: String,
    @SerializedName("dateOfBirth") val dateOfBirth: String,
    @SerializedName("creationTime") val creationTime: String,
    @SerializedName("description") val description: String?,
    @SerializedName("active") val active: Boolean
)

data class Account(
    @SerializedName("id") val id: Int,
    @SerializedName("accountNumber") val accountNumber: String,
    @SerializedName("accountName") val accountName: String,
    @SerializedName("balance") val balance: Double,
    @SerializedName("currency") val currency: String,
    @SerializedName("accountType") val accountType: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("customer") val customer: Customer
)

data class Transaction(
    @SerializedName("id") val id: Int,
    @SerializedName("fromAccount") val fromAccount: Account,
    @SerializedName("toAccount") val toAccount: Account,
    @SerializedName("amount") val amount: Double,
    @SerializedName("convertedAmount") val convertedAmount: Double,
    @SerializedName("transactionType") val transactionType: String,
    @SerializedName("description") val description: String?,
    @SerializedName("status") val status: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("updatedAt") val updatedAt: String
)

data class TransferRequest(
    @SerializedName("sourceAccountId") val sourceAccountId: Int,
    @SerializedName("destinationAccountId") val destinationAccountId: Int,
    @SerializedName("amount") val amount: Double,
    @SerializedName("transactionType") val transactionType: String
)
