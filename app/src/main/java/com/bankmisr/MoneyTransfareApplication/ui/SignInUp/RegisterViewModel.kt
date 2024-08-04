package com.bankmisr.MoneyTransfareApplication.ui.SignInUp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bankmisr.MoneyTransfareApplication.apis.register.registerAPIService
import com.bankmisr.MoneyTransfareApplication.models.register
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private val _registrationResponse = MutableLiveData<register>()
    val registrationResponse: LiveData<register> = _registrationResponse

    private val _hasError= MutableStateFlow(false)
    val hasError = _hasError.asStateFlow()

    var success= false

    fun registerUser(register: register) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = registerAPIService.callable.registerUser(register)
                if (response.isSuccessful) {
                    success= true
                    _registrationResponse.postValue(response.body())
                    _hasError.update{false}
                } else {
                    Log.d("trace","not successful")
                }
            } catch (e: Exception) {
                _hasError.update { true }
                Log.d("trace","Error: ${e.message}")

            }
        }

    }
}
