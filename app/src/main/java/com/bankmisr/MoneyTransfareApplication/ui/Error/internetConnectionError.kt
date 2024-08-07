package com.bankmisr.MoneyTransfareApplication.ui.Error

import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.bankmisr.MoneyTransfareApplication.R
import com.bankmisr.MoneyTransfareApplication.Routes.Route
import com.bankmisr.MoneyTransfareApplication.ui.main.isInternetAvailable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun connectionError(modifier: Modifier = Modifier, navController: NavController) {

    var context= LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.seashell)
                )
            )
        }
    ) { _ ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            colorResource(id = R.color.seashell),
                            colorResource(id = R.color.pastel)
                        ),
                        end = Offset(0f, Float.POSITIVE_INFINITY)
                    )
                )
                .padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(263.dp)//.weight(0.25f)
                    //.shadow(elevation = 4.dp, clip = true)
                    .padding(1.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(painter =  painterResource(id = R.drawable.no_internet),
                    contentDescription = "status" )
            }

            Text(
                text ="Internet connection disabled..." , // note.noteDetails,
                fontSize = 24.sp,
                lineHeight = 36.sp ,
                fontWeight = W600 ,
                style = MaterialTheme.typography.bodyMedium ,
                color = colorResource(id = R.color.G900),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(10.dp)
                    //  .height(21.dp)
                      .width(293.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
            )
            Button(
                onClick = {
                    Intent(Settings.ACTION_WIRELESS_SETTINGS)
                    if(isInternetAvailable(context)){
                        context.startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .width(343.dp)
                    .height(60.dp)
                    .padding(top = 20.dp)
                ,
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.marron))
            ) {
                Text(text ="Update",color = colorResource(id = R.color.white),
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 21.sp,
                    textAlign = TextAlign.Center )
            }


        }

    }
}
