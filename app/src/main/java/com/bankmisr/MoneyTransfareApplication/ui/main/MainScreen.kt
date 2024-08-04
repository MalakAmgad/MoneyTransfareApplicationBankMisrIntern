package com.bankmisr.MoneyTransfareApplication.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bankmisr.MoneyTransfareApplication.Routes.MainNavigation

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) { innerPadding ->
        MainNavigation()
    }

}