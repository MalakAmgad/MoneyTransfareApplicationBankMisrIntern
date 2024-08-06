package com.bankmisr.MoneyTransfareApplication.ui.main.home.notifications

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bankmisr.MoneyTransfareApplication.R
import com.bankmisr.MoneyTransfareApplication.Routes.Route.TRANSACTIONSDetails
import com.bankmisr.MoneyTransfareApplication.database.Transaction
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signup1.UserViewModel
import com.bankmisr.MoneyTransfareApplication.ui.commonUI.bottomBar
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(navController: NavController,
                 modifier: Modifier = Modifier,
                 viewModel: UserViewModel = viewModel()
) {

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center) {
                        Text(
                            text = "Notifications",
                            color = colorResource(id = R.color.G900),
                            modifier = Modifier
                                .width(124.dp)
                                .padding(bottom = 10.dp)
                                .height(30.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 30.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.drop_down_1),
                        contentDescription = "Back",
                        modifier = Modifier.clickable { navController.popBackStack() }
                    )
                }
                , colors = TopAppBarDefaults.topAppBarColors(
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
                            colorResource(id = R.color.pastel),
                            //    colorResource(id = R.color.pastel)
                        ),
                        end = Offset(0f, Float.POSITIVE_INFINITY)
                    )
                )
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val transactions by viewModel.getAllTransactions().collectAsState(initial = emptyList())


            LazyColumn(modifier = modifier
                .padding(top = 16.dp)
                .weight(0.2f)) {
                items(transactions.size) { index ->
                    if (transactions[index].status==true)
                    {
                        NotificationsListItem(transaction = transactions[index] )
                    {
                        navController.navigate("$TRANSACTIONSDetails/${transactions}")
                    }
                    }
                }
            }
        }
    }
}

@Composable
fun NotificationsListItem(transaction: Transaction, modifier: Modifier = Modifier, onNavigate: () -> Unit
) {
    val transactionDate = Date(transaction.date) // Convert timestamp to Date
    val calendarTransaction = Calendar.getInstance().apply { time = transactionDate }
    val calendarToday = Calendar.getInstance()
    val date = Date(transaction.date)
    val format = SimpleDateFormat("dd MMMM yyyy HH:mm", Locale.getDefault()) // Customize the format as needed
    val formattedDate = format.format(date)
    Card(
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.p50)),
        modifier = modifier
            .fillMaxWidth()//.height(121.dp)
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable { onNavigate() }
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(121.dp)
                .padding(5.dp)
        ) {

            val dateFormat = SimpleDateFormat("yyyy-MM-dd hh:mma", Locale.getDefault())
            //val transactionDate = dateFormat.parse(transaction.date)
            Box(
                modifier = modifier
                    .height(64.dp)
                    .width(56.66.dp)
                    .padding(8.dp)
                    //.clip(RoundedCornerShape(8.dp))
                    .weight(0.15f)
                    .background(
                        colorResource(id = R.color.p75),
                        CircleShape
                    ) // Set background color
                    .clickable {
                        onNavigate()
                    },
                contentAlignment = Alignment.Center
            ) {
                Image( // Use Image composable to display the drawable
                    painter = painterResource(id = R.drawable.received_1),
                    colorFilter = ColorFilter.tint(colorResource(id = R.color.p300)),
                    contentDescription = "Card", modifier = modifier
                        .height(36.3.dp)
                        .width(36.3.dp)
                        .padding()
                )
            }


            Column(
                modifier = modifier.fillMaxWidth()
                    .padding(10.dp)
                    .weight(0.5f)
            ) {
                Text(
                    text = "Receive Transaction", // note.noteDetails,
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontWeight = W500,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.G900),
                    textAlign = TextAlign.Justify,
                    modifier = modifier
                        .height(21.dp)
                        .width(119.dp)
                        .wrapContentHeight(Alignment.CenterVertically)
                )
                Text(
                    text = "You have received ${transaction.amount} USD from ${transaction.sender} ${transaction.SenderAcount} xxx", // note.noteDetails,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontWeight = W400,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.G700),
                    textAlign = TextAlign.Justify,
                    modifier = modifier
                        .height(18.dp)
                        //.width(137.dp)
                        .wrapContentHeight(Alignment.CenterVertically)
                )
                Text(
                    text = "${formattedDate}", // note.noteDetails,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontWeight = W400,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.G100),
                    textAlign = TextAlign.Justify,
                    modifier = modifier
                        .height(18.dp)
                        //.width(132.dp)
                        .wrapContentHeight(Alignment.CenterVertically)
                )

            }

        }
    }

}

/*
@Preview
@Composable
fun TransactionsPreview() {
    TransactionsListItem(transaction =Transaction(amount = 500.0,
        sender = "Alice",
        SenderAcount = "12345",
        receiver = "Bob",
        receiverAcount = "98765",
        reference = "REF54321",
        date = Date().time,
        status = "Successful"))
   // Transactions()
}*/