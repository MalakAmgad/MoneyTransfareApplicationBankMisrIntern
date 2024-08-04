package com.bankmisr.MoneyTransfareApplication.ui.SignInUp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.SpeedoTransfare.SpeedoTransfare

class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpeedoTransfare()
        }
    }
}