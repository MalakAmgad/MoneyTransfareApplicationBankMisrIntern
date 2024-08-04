package com.bankmisr.MoneyTransfareApplication.ui.SignInUp.SpeedoTransfare

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.bankmisr.MoneyTransfareApplication.R


@Composable
fun SpeedoTransfare (modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(colorResource(id= R.color.Burgundy))
            .fillMaxSize()
        )
    {
        Text(
            text = "Speedo Transfer",
            fontSize = 32.sp,
            lineHeight = 38.73.sp ,// Line height should also use sp units
            color = Color.White
        )
    }
}


@Preview
@Composable
private fun SpeedoTransfarePreview() {
    SpeedoTransfare()
}