package com.bankmisr.MoneyTransfareApplication.ui.main.transfare

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.bankmisr.MoneyTransfareApplication.R
import com.bankmisr.MoneyTransfareApplication.Routes.MainRout
import com.bankmisr.MoneyTransfareApplication.database.Transaction
import java.util.Date


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransferConfirmationScreen(t: Transaction, modifier: Modifier = Modifier, navController: NavController) {


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp),
                    ) {
                        Text(
                            text = "Successful Transactions",
                            color = colorResource(id = R.color.G900),
                            modifier = Modifier
                                .padding(bottom = 10.dp)
                                .height(30.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 30.sp,
                        )
                    }
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.drop_down_1),
                        contentDescription = "Back",
                        modifier = Modifier.clickable { navController.popBackStack() }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.seashell)
                )
            )
        },
    ) { innerPadding ->

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
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(14.dp))
            StepIndicator1(currentStep = 2)

            Spacer(modifier = Modifier.height(15.dp))


            // Adjusted Text Columns
            Column {
                Text(
                    text = "${t.amount} USD",
                    color = colorResource(id = R.color.G900),
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = "Transfare amount",
                    color = colorResource(id = R.color.G900),
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))

            }
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(0.5f),
              //  verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(modifier = modifier.padding(10.dp)) {
                    Text(
                        text = "Transfer amount amount",
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400,
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorResource(id = R.color.G700),
                        textAlign = TextAlign.Justify,
                        modifier = modifier.wrapContentHeight(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "${t.amount * 48} EGP",
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400,
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorResource(id = R.color.G100),
                        textAlign = TextAlign.End,
                        modifier = modifier
                            .fillMaxWidth()
                    )
                }

                HorizontalDivider(
                    color = colorResource(id = R.color.p55),
                    thickness = 1.dp,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        //  .height(50.dp)
                        .fillMaxWidth()
                )
            // New position for the SmallFloatingActionButton

            // Card Columns
            Column {


                Box(modifier = Modifier.fillMaxWidth()) {
                    Column {
                        Spacer(modifier = Modifier.height(20.dp))
                        //first card
                        Card(
                            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.p50)),
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(horizontal = 18.dp, vertical = 4.dp)
                        ) {
                            Row(
                                modifier = modifier
                                    .fillMaxWidth()
                                    // .height(121.dp)
                                    .padding(5.dp)
                            ) {
                                Column {
                                    Box(
                                        modifier = modifier
                                            .padding(15.dp)
                                            .padding(top = 15.dp)
                                            .size(40.dp)
                                            .background(
                                                colorResource(id = R.color.G40),
                                                CircleShape
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.bank_1),
                                            colorFilter = ColorFilter.tint(colorResource(id = R.color.darkGreen)),
                                            contentDescription = "Card",
                                            modifier = modifier
                                                .height(36.3.dp)
                                                .width(36.3.dp)
                                                .padding()
                                        )
                                    }
                                }
                                Column(
                                    modifier = modifier
                                        .padding(10.dp)
                                        .fillMaxWidth()
                                        .weight(0.5f),
                                    verticalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "From",
                                        fontSize = 16.sp,
                                        lineHeight = 24.sp,
                                        fontWeight = FontWeight.W500,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = colorResource(id = R.color.p300),
                                        textAlign = TextAlign.Justify,
                                        modifier = modifier.wrapContentHeight(Alignment.CenterVertically)
                                    )
                                    Text(
                                        text = "${t.sender}",
                                        fontSize = 20.sp,
                                        lineHeight = 30.sp,
                                        fontWeight = FontWeight.W600,
                                        style = MaterialTheme.typography.titleMedium,
                                        color = colorResource(id = R.color.G900),
                                        textAlign = TextAlign.Justify,
                                        modifier = modifier.wrapContentHeight(Alignment.CenterVertically)
                                    )
                                    Text(
                                        text = "Account xxxx${t.SenderAcount}",
                                        fontSize = 16.sp,
                                        lineHeight = 18.sp,
                                        fontWeight = FontWeight.W400,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = colorResource(id = R.color.G100),
                                        textAlign = TextAlign.Justify,
                                        modifier = modifier
                                            .height(18.dp)
                                            .wrapContentHeight(Alignment.CenterVertically)
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        // Second Card
                        Card(
                            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.p50)),
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(horizontal = 18.dp, vertical = 4.dp)
                        ) {
                            Row(
                                modifier = modifier
                                    .fillMaxWidth()
                                    //  .height(121.dp)
                                    .padding(5.dp)
                            ) {
                                Column {
                                    Box(
                                        modifier = modifier
                                            .padding(15.dp)
                                            .padding(top = 15.dp)
                                            .size(40.dp)
                                            .background(
                                                colorResource(id = R.color.G40),
                                                CircleShape
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.bank_1),
                                            colorFilter = ColorFilter.tint(colorResource(id = R.color.darkGreen)),
                                            contentDescription = "Card",
                                            modifier = modifier
                                                .height(36.3.dp)
                                                .width(36.3.dp)
                                                .padding()
                                        )
                                    }
                                }
                                Column(
                                    modifier = modifier
                                        .padding(10.dp)
                                        .fillMaxWidth()
                                        .weight(0.5f),
                                    verticalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "To",
                                        fontSize = 16.sp,
                                        lineHeight = 24.sp,
                                        fontWeight = FontWeight.W500,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = colorResource(id = R.color.p300),
                                        textAlign = TextAlign.Justify,
                                        modifier = modifier.wrapContentHeight(Alignment.CenterVertically)
                                    )
                                    Text(
                                        text = "${t.receiver}",
                                        fontSize = 20.sp,
                                        lineHeight = 30.sp,
                                        fontWeight = FontWeight.W600,
                                        style = MaterialTheme.typography.titleMedium,
                                        color = colorResource(id = R.color.G900),
                                        textAlign = TextAlign.Justify,
                                        modifier = modifier.wrapContentHeight(Alignment.CenterVertically)
                                    )
                                    Text(
                                        text = "Account xxxx${t.receiverAcount}",
                                        fontSize = 16.sp,
                                        lineHeight = 18.sp,
                                        fontWeight = FontWeight.W400,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = colorResource(id = R.color.G100),
                                        textAlign = TextAlign.Justify,
                                        modifier = modifier
                                            .height(18.dp)
                                            .wrapContentHeight(Alignment.CenterVertically)
                                    )
                                }
                            }
                        }
                    }


                    SmallFloatingActionButton(
                        onClick = { /* Handle click */ },
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(44.dp)
                            .offset(x = (-16).dp, y = (9).dp)
                            .zIndex(2f), // Set a higher zIndex value
                        containerColor = colorResource(id = R.color.yellow),
                        contentColor = Color.White,
                        shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
                        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 6.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.transfer_money_1), modifier = modifier.size(26.dp),
                            contentDescription = "Confirm"
                        )
                    }
                }
            }

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(121.dp)
                    .padding(5.dp)
            ) {

                    Button(
                        onClick = {
                            //navigate
                            navController.navigate("${MainRout.TRANSFAREPAYMENT }/${t}")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(343.dp)
                            .height(60.dp)
                            .padding(top = 10.dp),
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.marron))
                    ) {
                        Text(
                            text = "Confirmation", color = colorResource(id = R.color.white),
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 21.sp,
                            textAlign = TextAlign.Center
                        )
                    }

                }
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(121.dp)
                        .padding(5.dp)
                ) {


                    var buttonClicked by remember { mutableStateOf(false) }
                    Button(
                        onClick = {
                            buttonClicked = !buttonClicked


                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(343.dp)
                            .height(60.dp)
                           // .padding(top = 10.dp)
                            .border(
                                width = 2.dp, // Adjust border width as needed
                                color = colorResource(id = R.color.marron),
                                shape = RoundedCornerShape(6.dp)
                            ),
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(
                            if (buttonClicked) colorResource(id = R.color.marron) else Color.Transparent

                        )
                    ) {
                        Text(
                            text = "Add to Favourite",
                            color = if (buttonClicked) colorResource(id = R.color.white) else colorResource(
                                id = R.color.marron
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 21.sp,
                            textAlign = TextAlign.Center
                        )
                    }

                }

            }
        }

    }
}

@SuppressLint("MissingPermission")
@Composable
fun sendNotification(context: Context, title: String, text: String) {
    //var notification = painterResource(id = R.drawable.notification)
    val builder = NotificationCompat.Builder(context, "1")
        .setSmallIcon(R.drawable.notification)
        .setContentTitle(title)
        .setContentText(text)
        .setAutoCancel(true)


    // Show notification if permission is granted

    NotificationManagerCompat.from(context).notify(99, builder.build())

}
