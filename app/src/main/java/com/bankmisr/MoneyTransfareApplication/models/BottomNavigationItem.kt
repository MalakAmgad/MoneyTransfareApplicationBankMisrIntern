package com.bankmisr.MoneyTransfareApplication.models

import androidx.annotation.DrawableRes

data class BottomNavigationItem(
    val title: String,
    @DrawableRes
    val selectedIcon: Int,
)