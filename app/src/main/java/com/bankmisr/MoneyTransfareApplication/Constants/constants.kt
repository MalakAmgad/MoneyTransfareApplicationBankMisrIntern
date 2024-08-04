package com.bankmisr.MoneyTransfareApplication.Constants

object Constants {
    const val BASE_URL = "http://localhost:8080"

    // Register API
    const val REGISTER_ENDPOINT = "/api/register"
    const val REGISTER_FIRST_NAME = "firstName"
    const val REGISTER_LAST_NAME = "lastName"
    const val REGISTER_GENDER = "gender"
    const val REGISTER_EMAIL = "email"
    const val REGISTER_PHONE_NUMBER = "phoneNumber"
    const val REGISTER_ADDRESS = "address"
    const val REGISTER_NATIONALITY = "nationality"
    const val REGISTER_NATIONAL_NUMBER = "nationalNumber"
    const val REGISTER_DATE_OF_BIRTH = "dateOfBirth"
    const val REGISTER_PASSWORD = "password"

    // Login API
    const val LOGIN_ENDPOINT = "/api/login"
    const val EMAIL_KEY = "email"
    const val PASSWORD_KEY = "password"
    const val TOKEN_KEY = "token"
    const val TOKEN_TYPE_KEY = "tokenType"
    const val MESSAGE_KEY = "message"
    const val STATUS_CODE_KEY = "statusCode"

    // Logout API
    const val LOGOUT_ENDPOINT = "/api/logout"

    // Accounts API
    const val ACCOUNTS_ENDPOINT = "/api/accounts"
    const val ACCOUNT_SPECIFIC_ENDPOINT = "/api/accounts/{id}"

    // Transactions API
    const val TRANSFER_ENDPOINT = "/api/transactions/transfer"
    const val TRANSACTIONS_ENDPOINT = "/api/transactions"
    const val TRANSACTION_SPECIFIC_ENDPOINT = "/api/transactions/{id}"
    const val TRANSACTIONS_ACCOUNT_ENDPOINT = "/api/transactions/account/{accountId}"
    const val TRANSFER_SOURCE_ACCOUNT_ID = "sourceAccountId"
    const val TRANSFER_DESTINATION_ACCOUNT_ID = "destinationAccountId"
    const val TRANSFER_AMOUNT = "amount"
    const val TRANSFER_TRANSACTION_TYPE = "transactionType"

    // Favorite Recipient API
    const val FAVORITES_ENDPOINT = "/api/favorites/{customerId}/{recipientId}"
    const val FAVORITES_CUSTOMER_ENDPOINT = "/api/favorites/{customerId}"
}
