package com.bankmisr.MoneyTransfareApplication.ui.main.Transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bankmisr.MoneyTransfareApplication.apis.Transaction.TransactionAPIService
import com.bankmisr.MoneyTransfareApplication.models.Transaction
import com.bankmisr.MoneyTransfareApplication.models.TransferRequest
import kotlinx.coroutines.launch

class TransactionViewModel : ViewModel() {
    private val _transferResponse = MutableLiveData<Transaction>()
    val transferResponse: LiveData<Transaction> = _transferResponse

    fun transferMoney(sourceAccountId: Int, destinationAccountId: Int, amount: Double) {
        viewModelScope.launch {
            try {
                val transferRequest = TransferRequest(
                    sourceAccountId = sourceAccountId,
                    destinationAccountId = destinationAccountId,
                    amount = amount,
                    transactionType = "DEPOSIT"
                )
                val response =  TransactionAPIService.api.transferMoney(transferRequest)
                if (response.isSuccessful) {
                    _transferResponse.postValue(response.body())
                } else {
                    // Handle error
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
