package com.bankmisr.MoneyTransfareApplication.ui.main.home

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bankmisr.MoneyTransfareApplication.R
import com.bankmisr.MoneyTransfareApplication.Routes.MainRout.NOTIFICATION
import com.bankmisr.MoneyTransfareApplication.database.Transaction
import com.bankmisr.MoneyTransfareApplication.database.user.User
import com.bankmisr.MoneyTransfareApplication.models.Account
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signup1.UserViewModel
import com.bankmisr.MoneyTransfareApplication.ui.main.Transaction.TransactionViewModel
import com.bankmisr.MoneyTransfareApplication.ui.main.home.notifications.NotificationScreen
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = viewModel()
) {
    val account=(31506481565).toLong()
    val userAccount = remember { mutableStateOf<User?>(null) }
    LaunchedEffect(key1 = account) {
        viewModel.gatUserAccount(account).collect { user ->
            userAccount.value = user
        }
    }

    val Useraccount = userAccount.value ?: User(fullName = "r l", email = " ", password = "", DateofBirth = ""
    , Balance = 0.0, accountNumber = 0 )

    val userName = Useraccount.fullName
    val (firstname, lastname)=userName.split(" ", limit = 2)
    val balance = Useraccount.Balance


    Scaffold(
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE)))

                )
        ) {
            WelcomeTitle(userName,firstname,lastname,navController)
            CurrentBalanceCard(balance)
            ServicesCard()
            Row(modifier = modifier.padding(horizontal = 10.dp)) {
                Text(
                    text = "Recent transactions",
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.W400,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.G900),
                    textAlign = TextAlign.Justify,
                    modifier = modifier.wrapContentHeight(Alignment.CenterVertically)
                )
                Text(
                    text = "view All",
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.W400,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.G200),
                    textAlign = TextAlign.End,
                    modifier = modifier
                        .fillMaxWidth()
                        .clickable {

                        }
                )
            }
            Column(
                modifier = modifier
                    .fillMaxWidth()//.height(121.dp)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                //.clickable { onNavigate() }
            ) {

                val transactions by viewModel.getuserTransactions(Useraccount.accountNumber).collectAsState(initial = emptyList())


                LazyColumn(modifier = modifier
                    .padding(top = 16.dp)
                    .weight(0.2f)){
                    items(transactions) { transaction ->  // Iterate directly over the limited list
                        RecentTransactionsListItem(transaction = transaction) /*{
                            navController.navigate("$TRANSACTIONSDetails/${transaction}")
                        }*/
                    }
                }
            }

        }
    }




}


@Composable
fun RecentTransactionsListItem(transaction: Transaction, modifier: Modifier = Modifier//, onNavigate: () -> Unit
) {
    Row(modifier = modifier
        .fillMaxWidth()
        .background(color = Color.White)
        //.height(77.dp)
       // .padding(bottom = 5.dp)
        )
    {

        val dateFormat = SimpleDateFormat("yyyy-MM-dd hh:mma", Locale.getDefault())
        //val transactionDate = dateFormat.parse(transaction.date)
        Box (
            modifier = modifier
                .height(64.dp)
                .width(61.66.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
                .weight(0.15f)
                .background(colorResource(id = R.color.p50)) // Set background color
                .clickable {
                    //    onNavigate()
                },
            contentAlignment = Alignment.Center
        ){
            Image( // Use Image composable to display the drawable
                painter = painterResource(id = R.drawable.visa),
               // colorFilter = ColorFilter.tint(colorResource(id = R.color.p300)),
                contentDescription = "Card" , modifier = modifier
                    .height(36.3.dp)
                    .width(36.3.dp)
                    .padding()
            )
        }

        val transactionDate = Date(transaction.date) // Convert timestamp to Date
        val calendarTransaction = Calendar.getInstance().apply { time = transactionDate }
        val calendarToday = Calendar.getInstance()
        Column (modifier = modifier
            .padding(10.dp)
            .weight(0.5f)
        ){
            Text(
                text = transaction.receiver, // note.noteDetails,
                fontSize = 14.sp,
                lineHeight = 21.sp ,
                fontWeight = W500 ,
                style = MaterialTheme.typography.bodyMedium ,
                color = colorResource(id = R.color.G900),
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .height(21.dp)
                    .width(119.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
            )
            Text(
                text = "Visa.MasterCrad.${transaction.SenderAcount}", // note.noteDetails,
                fontSize = 12.sp,
                lineHeight = 18.sp ,
                fontWeight = W400 ,
                style = MaterialTheme.typography.bodyMedium ,
                color = colorResource(id = R.color.G700),
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .height(18.dp)
                    //.width(137.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
            )
            Text(
                text = if (calendarTransaction.get(Calendar.YEAR) == calendarToday.get(
                        Calendar.YEAR) &&
                    calendarTransaction.get(Calendar.MONTH) == calendarToday.get(Calendar.MONTH) &&
                    calendarTransaction.get(Calendar.DAY_OF_MONTH) == calendarToday.get(
                        Calendar.DAY_OF_MONTH)) {
                    "Today ${SimpleDateFormat("hh:mma", Locale.getDefault()).format(transactionDate)}-Received"
                } else {
                    "${SimpleDateFormat("dd MMM,hh:mma", Locale.getDefault()).format(transactionDate)} - Received"
                }, // note.noteDetails,
                fontSize = 12.sp,
                lineHeight = 18.sp ,
                fontWeight = W400 ,
                style = MaterialTheme.typography.bodyMedium ,
                color = colorResource(id = R.color.G100),
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .height(18.dp)
                    //.width(132.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
            )

        }

        Text(
            text = " ${String.format("$%.2f", transaction.amount)}", // note.noteDetails,
            fontSize = 16.sp,
            lineHeight = 24.sp ,
            fontWeight = W500 ,
            style = MaterialTheme.typography.bodyMedium ,
            color = colorResource(id = R.color.p300) ,
            textAlign = TextAlign.Justify,
            modifier = modifier
                //  .height(24.dp)
                //  .width(49.dp)
                .padding(6.dp)
                .wrapContentHeight(Alignment.CenterVertically)
        )


    }

}
@Composable
fun WelcomeTitle(userName: String,firstname:String ,lastname:String ,navController: NavController,viewModel: TransactionViewModel= androidx.lifecycle.viewmodel.compose.viewModel()) {
    val initials: String = "${firstname.firstOrNull() ?: ""}${lastname.firstOrNull() ?: ""}"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {

            Box(
                modifier = Modifier
                    .size(64.dp).height(77.dp)
                    .padding(10.dp)
                    .background(color = colorResource(id = R.color.G40), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = initials.uppercase(),
                    color = colorResource(id = R.color.G100),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            Column() {
                Text(text = stringResource(id = R.string.welcome), color = Color(0xFF871E35))
                Text(text = userName)
            }
        }
        Image(
            painter = painterResource(id = R.drawable.notifications_1),
            contentDescription = stringResource(
                id = R.string.Photo
            ),
            Modifier
                .size(40.dp)
                .clickable { navController.navigate(NOTIFICATION) }
        )
    }
}


@Composable
fun CurrentBalanceCard(balance: Double) {
    val decimalFormat = DecimalFormat("#,###.##")
    val formattedBalance = decimalFormat.format(balance)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(123.dp)
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF871E35)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(-5.dp, 0.dp)
                    .padding(10.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.currentBalance),
                    color = Color.White,
                    fontSize = 20.sp
                )
            }

            Text(text = "$$formattedBalance", color = Color.White, fontSize = 30.sp)

        }
    }
}

@Composable
fun ServicesCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(121.dp)

        ,
        colors = CardDefaults.cardColors(
            containerColor = Color.White // Background color
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.services), color = Color.Black,
                modifier = Modifier.padding(top=10.dp, start = 10.dp), fontSize = 16.sp)

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ServicesImage(image = R.drawable.transfer_1, text = R.string.Transfer)
                ServicesImage(image = R.drawable.history_1, text = R.string.Transactions)
                ServicesImage(image = R.drawable.cards_1, text = R.string.Cards)
                ServicesImage(image = R.drawable.account_1, text = R.string.Account)
            }
        }
    }
}

@Composable
fun ServicesImage(image: Int,text:Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ) {

        Image(
            painter = painterResource(image),
            colorFilter = ColorFilter.tint(colorResource(id = R.color.yellow)),
            contentDescription = stringResource(id = R.string.Photo),
            modifier= Modifier
                .width(40.dp)
                .padding(bottom = 10.dp)
            // .height(60.dp)
        )
        Text(
            text = stringResource(text), // note.noteDetails,
            fontSize = 12.sp,
            lineHeight = 18.sp ,
            fontWeight = W400 ,
            style = MaterialTheme.typography.bodyMedium ,
            color = colorResource(id = R.color.G700),
            textAlign = TextAlign.Justify,

        )
    }
}

@Composable
fun RecentTransactions (image: Int,text:Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = stringResource(
                id = R.string.Photo
            ),
            Modifier
                .width(40.dp)
                .height(60.dp)
        )
        Text(text = stringResource(text))
    }
}




/*
@Preview
@Composable
private fun TransferPreview() {
    TransferMainScreen()
}*/