package com.bankmisr.MoneyTransfareApplication

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.bankmisr.MoneyTransfareApplication.Routes.ApppNavHost
import com.bankmisr.MoneyTransfareApplication.Routes.MainNavigation
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.SpeedoTransfare.SpeedoTransfare
import com.bankmisr.MoneyTransfareApplication.ui.main.MainScreen
import com.bankmisr.MoneyTransfareApplication.ui.theme.MoneyTransfareApplicationTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var showSplashScreen by remember { mutableStateOf(true) }

            if (showSplashScreen) {
                SpeedoTransfare()

                LaunchedEffect(key1 = true) {
                   showSplashScreen = false
                }
            } else {
                MoneyTransfareApplicationTheme {
                        MainNavigation()
                }
            }

        }
    }
}

