package com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signIn

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bankmisr.MoneyTransfareApplication.apis.signIn.signInAPIService
import com.bankmisr.MoneyTransfareApplication.models.LoginRequest
import com.bankmisr.MoneyTransfareApplication.models.LoginResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _loginResponse = MutableLiveData<LoginResponse>()
    val loginResponse: LiveData<LoginResponse> = _loginResponse

    private val _hasError= MutableStateFlow(false)
    val hasError = _hasError.asStateFlow()
    var success= false

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(email, password)
                val response = signInAPIService.api.loginUser(loginRequest)
                if (response.isSuccessful) {
                    success =true
                    _loginResponse.postValue(response.body())
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
