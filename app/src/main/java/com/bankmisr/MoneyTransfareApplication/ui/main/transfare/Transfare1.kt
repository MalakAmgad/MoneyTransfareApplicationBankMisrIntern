package com.bankmisr.MoneyTransfareApplication.ui.main.transfare

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bankmisr.MoneyTransfareApplication.R
import com.bankmisr.MoneyTransfareApplication.Routes.Route.TRANSACTIONSDetails
import com.bankmisr.MoneyTransfareApplication.database.Transaction
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signUp2.CountrieslList
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signUp2.DataSource
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signup1.UserViewModel
import com.bankmisr.MoneyTransfareApplication.ui.commonUI.bottomBar
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

 class Recipient() {
    companion object {
        var RecipientName: String=""
        var RecipientAccount: String=""
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransferScreen(navController: NavController,
                 modifier: Modifier = Modifier,
                 viewModel: UserViewModel = viewModel()
) {
    var showBottomSheet by remember { mutableStateOf(false) }
var amountUSD=1
    var usdEgp=48.4220
    var amountEGP=(amountUSD *usdEgp)

    var RecipientName by remember { mutableStateOf(Recipient.RecipientName) }
    var RecipientAccount by remember { mutableStateOf(Recipient.RecipientAccount) }
    val sheetState = rememberModalBottomSheetState()


    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center) {
                        Text(
                            text = "Transfer",
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
        LazyColumn( // Replace Column with LazyColumn
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
                .padding(innerPadding)
        ) {
            // Step Indicator
            item {
                StepIndicator1(currentStep = 1)
            }
            // Your content here
            item {
            Text(
                text = " How much are you sending?", // note.noteDetails,
                fontSize = 20.sp,
                lineHeight = 30.sp ,
                fontWeight = W600 ,
                style = MaterialTheme.typography.bodyMedium ,
                color = colorResource(id = R.color.G900) ,
                textAlign = TextAlign.Left,
                modifier = modifier
                    //  .height(24.dp)
                    //  .width(49.dp)
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
            )}
            item {Text(
                text = "Choose Currency", // note.noteDetails,
                fontSize = 16.sp,
                lineHeight = 24.sp ,
                fontWeight = W600 ,
                style = MaterialTheme.typography.bodyMedium ,
                color = colorResource(id = R.color.G900) ,
                textAlign = TextAlign.Left,
                modifier = modifier
                    //  .height(24.dp)
                    //  .width(49.dp)
                    .fillMaxWidth()
                    .padding(6.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
            )}
            item {Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "1 USD = ${usdEgp} EGP", // note.noteDetails,
                    fontSize = 16.sp,
                    lineHeight = 24.sp ,
                    fontWeight = W600 ,
                    style = MaterialTheme.typography.bodyMedium ,
                    color = colorResource(id = R.color.G700) ,
                    textAlign = TextAlign.Left,
                    modifier = modifier
                        //  .height(24.dp)
                        //  .width(49.dp)
                        .fillMaxWidth()
                        .padding(6.dp)
                        .wrapContentHeight(Alignment.CenterVertically)
                )
                Text(
                    text = " Rate guaranteed (2h)", // note.noteDetails,
                    fontSize = 14.sp,
                    lineHeight = 21.sp ,
                    fontWeight = W600 ,
                    style = MaterialTheme.typography.bodyMedium ,
                    color = colorResource(id = R.color.G100) ,
                    textAlign = TextAlign.Left,
                    modifier = modifier
                        //  .height(24.dp)
                        //  .width(49.dp)
                        .fillMaxWidth()
                        .padding(6.dp)
                        .wrapContentHeight(Alignment.CenterVertically)
                )
                Text(
                    text = "You Send",
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.W400,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.G700),
                    textAlign = TextAlign.Left,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp, horizontal = 8.dp)
                )
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        //  .height(121.dp)
                        .padding(5.dp),
                    Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = modifier
                            .weight(0.5f),
                        verticalArrangement = Arrangement.Top
                    ) {

                            Row {
                                Box (
                                    modifier = modifier
                                        .height(46.dp)
                                        .width(117.66.dp)
                                        .padding(8.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .weight(0.15f)
                                        .background(Color.White) // Set background color
                                        ,
                                  //  contentAlignment = Alignment.Center
                                ){
                                   Row {
                                       Image( // Use Image composable to display the drawable
                                           painter = painterResource(id = R.drawable.united_states),
                                           contentDescription = "Card" , modifier = modifier
                                               .height(36.3.dp)
                                               .width(36.3.dp)
                                               .padding())
                                       Text(
                                           text = "USD",
                                           fontSize = 20.sp,
                                           lineHeight = 30.sp,
                                           fontWeight = FontWeight.W400,
                                           style = MaterialTheme.typography.titleMedium,
                                           color = colorResource(id = R.color.p300),
                                           textAlign = TextAlign.Center,
                                           modifier = modifier
                                               .padding(2.dp)
                                       )
                                       Image( // Use Image composable to display the drawable
                                           painter = painterResource(id = R.drawable.drop_down_1),
                                           colorFilter = ColorFilter.tint(colorResource(id = R.color.G900)),
                                           contentDescription = "Card" , modifier = modifier
                                               .rotate(-90f)
                                               .height(36.3.dp)
                                               .width(36.3.dp)
                                               .padding())
                                   }
                                   }

                            }
                    }
                    Box(
                        modifier = Modifier
                            .height(64.dp)
                            //.width(300.dp)
                            .weight(0.5f)
                            // .fillMaxWidth()  // Consider removing if you want to see left alignment
                            .padding(8.dp)
                            .clip(RoundedCornerShape(8.dp)) // Align to the left within the Column
                            .background(color = Color.White) // Set background color first
                            .border(color = colorResource(id = R.color.G100), width = 1.dp) // Then apply the border

                        ,
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "${amountUSD}",
                            fontSize = 20.sp,
                            lineHeight = 30.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium,
                            color = colorResource(id = R.color.G900),
                            textAlign = TextAlign.Center,
                            modifier = modifier
                                .padding(2.dp)
                        )
                    }
                    }
                HorizontalDivider(
                    color = colorResource(id = R.color.G40),
                    thickness = 1.dp,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        //  .height(50.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Recipient Gets",
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.W400,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.G700),
                    textAlign = TextAlign.Left,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp, horizontal = 8.dp)
                )
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        //  .height(121.dp)
                        .padding(5.dp),
                    Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = modifier
                            .weight(0.5f),
                        verticalArrangement = Arrangement.Top
                    ) {

                        Row {
                            Box (
                                modifier = modifier
                                    .height(46.dp)
                                    .width(117.66.dp)
                                    .padding(8.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .weight(0.15f)
                                    .background(Color.White) // Set background color
                                ,
                                //  contentAlignment = Alignment.Center
                            ){
                                Row {
                                    Image( // Use Image composable to display the drawable
                                        painter = painterResource(id = R.drawable.egypt),
                                        contentDescription = "Card" , modifier = modifier
                                            .height(36.3.dp)
                                            .width(36.3.dp)
                                            .padding())
                                    Text(
                                        text = "EGP",
                                        fontSize = 20.sp,
                                        lineHeight = 30.sp,
                                        fontWeight = FontWeight.W400,
                                        style = MaterialTheme.typography.titleMedium,
                                        color = colorResource(id = R.color.p300),
                                        textAlign = TextAlign.Center,
                                        modifier = modifier
                                            .padding(2.dp)
                                    )
                                    Image( // Use Image composable to display the drawable
                                        painter = painterResource(id = R.drawable.drop_down_1),
                                        colorFilter = ColorFilter.tint(colorResource(id = R.color.G900)),
                                        contentDescription = "Card" , modifier = modifier
                                            .rotate(-90f)
                                            .height(36.3.dp)
                                            .width(36.3.dp)
                                            .padding())
                                }
                            }

                        }
                    }
                    Box(
                        modifier = Modifier
                            .height(64.dp)
                            //.width(300.dp)
                            .weight(0.5f)
                            // .fillMaxWidth()  // Consider removing if you want to see left alignment
                            .padding(8.dp)
                            .clip(RoundedCornerShape(8.dp)) // Align to the left within the Column
                            .background(color = Color.White) // Set background color first
                            .border(color = colorResource(id = R.color.G100), width = 1.dp) // Then apply the border

                        ,
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "${amountEGP}",
                            fontSize = 20.sp,
                            lineHeight = 30.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium,
                            color = colorResource(id = R.color.G900),
                            textAlign = TextAlign.Center,
                            modifier = modifier
                                .padding(2.dp)
                        )
                    }
                }
                }}
            item {
            Row (horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Recipient Information", // note.noteDetails,
                    fontSize = 16.sp,
                    lineHeight = 24.sp ,
                    fontWeight = W600 ,
                    style = MaterialTheme.typography.bodyMedium ,
                    color = colorResource(id = R.color.G700) ,
                    textAlign = TextAlign.Left,
                    modifier = modifier
                        //  .height(24.dp)
                        //  .width(49.dp)
                        .padding(6.dp)
                        .weight(0.7f)
                        .wrapContentHeight(Alignment.CenterVertically)
                )

                Box (
                    modifier = modifier
                        .height(46.dp)
                        //  .width(117.66.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .weight(0.3f) // Set background color
                    ,
                    //  contentAlignment = Alignment.Center
                ){
                    Row (modifier = modifier.clickable{
                        showBottomSheet=true
                    }
                    ){
                        Image( // Use Image composable to display the drawable
                            painter = painterResource(id = R.drawable.favorite_1),
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.p300)),
                            contentDescription = "Card" , modifier = modifier
                                .rotate(180f)
                                .height(20.dp)
                                .width(20.dp)
                                .padding()
                        )
                        Text(
                            text = "Favourite",
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.W400,
                            style = MaterialTheme.typography.titleMedium,
                            color = colorResource(id = R.color.p300),
                            textAlign = TextAlign.Center,
                            modifier = modifier//.fillMaxWidth()
                                .padding(2.dp)
                        )
                        Image( // Use Image composable to display the drawable
                            painter = painterResource(id = R.drawable.drop_down_1),
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.p300)),
                            contentDescription = "Card" , modifier = modifier
                                .rotate(180f)
                                .height(20.dp)
                                .width(20.dp)
                                .padding()
                        )
                    }
                    if (showBottomSheet) {
                        ModalBottomSheet(
                            onDismissRequest = {
                                showBottomSheet = false
                            },
                            sheetState = sheetState

                        ) {
                            Column {
                                Row (
                                    horizontalArrangement = Arrangement.Center
                                ){
                                    Image( // Use Image composable to display the drawable
                                        painter = painterResource(id = R.drawable.favorite_1),
                                        colorFilter = ColorFilter.tint(colorResource(id = R.color.p300)),
                                        contentDescription = "Card" , modifier = modifier
                                            .rotate(180f)
                                            .height(20.dp)
                                            .width(20.dp)
                                            .padding()
                                    )
                                    Text(
                                        text = "Favourite",
                                        fontSize = 20.sp,
                                        lineHeight = 30.sp,
                                        fontWeight = FontWeight.W400,
                                        style = MaterialTheme.typography.titleMedium,
                                        color = colorResource(id = R.color.p300),
                                        textAlign = TextAlign.Center,
                                        modifier = modifier//.fillMaxWidth()
                                            .padding(2.dp)
                                    )}
                                val transactions by viewModel.getAllTransactions().collectAsState(initial = emptyList())
                                LazyColumn(modifier = modifier.padding(top = 16.dp).weight(0.2f)) {
                                    items(transactions.size) { index ->
                                        favouritListItem(
                                            transaction = transactions[index]
                                        )

                                    }
                                }


                            }
                            /*// Sheet content
                            Button(onClick = {
                                scope.launch { sheetState.hide() }.invokeOnCompletion {
                                    if (!sheetState.isVisible) {
                                        showBottomSheet = false
                                    }
                                }
                            }) {
                                Text("Hide bottom sheet")
                            }*/
                        }
                    }
                }

            }
                }
            item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                , verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Column() {
                    Text(
                        text = "Recipient Name",
                        modifier = Modifier.padding(top = 5.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        lineHeight = 24.sp,
                        textAlign = TextAlign.Left,
                        color = colorResource(id = R.color.G700)
                    )
                    OutlinedTextField(
                        value =RecipientName ,
                        onValueChange = { RecipientName = it },
                        modifier = Modifier
                            //  .width(343.dp)
                            .height(54.dp)
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.white)),
                        placeholder = {
                            Text(
                                "Enter Recipient Name",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400,
                                lineHeight = 21.sp,
                                color = colorResource(id = R.color.G70)
                            )
                        },

                    )
                }
                //  Spacer(modifier = modifier.padding(5.dp))
                Column() {
                    Text(
                        text = "Recipient Account",
                        modifier = Modifier.padding(top = 5.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        lineHeight = 24.sp,
                        textAlign = TextAlign.Left,
                        color = colorResource(id = R.color.G700)
                    )


                    OutlinedTextField(
                        value = RecipientAccount,
                        onValueChange = { RecipientAccount = it },
                        modifier = Modifier
                            // .width(343.dp)
                            .height(54.dp)
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.white)),
                        placeholder = {
                            Text(
                                "Enter Recipient Account Number",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400,
                                lineHeight = 21.sp,
                                color = colorResource(id = R.color.G70)
                            )
                        },
                    )
                }
                //   Spacer(modifier = modifier.padding(5.dp))
                Button(
                    onClick = {

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
                        text = "Continue", color = colorResource(id = R.color.white),
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 21.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }}



            }
    }


}

@Composable
fun favouritListItem(transaction: Transaction, modifier: Modifier = Modifier//, onNavigate: () -> Unit
) {


    Card(
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.p50)),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 4.dp).clickable{
                Recipient.RecipientName =transaction.receiver
                Recipient.RecipientAccount =transaction.receiverAcount
            }
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
                        .background(colorResource(id = R.color.G40), CircleShape),
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
                    text = "${transaction.receiver}",
                    fontSize = 16.sp,
                    lineHeight = 30.sp,
                    fontWeight = FontWeight.W600,
                    style = MaterialTheme.typography.titleMedium,
                    color = colorResource(id = R.color.G900),
                    textAlign = TextAlign.Justify,
                    modifier = modifier.wrapContentHeight(Alignment.CenterVertically)
                )
                Text(
                    text = "Account xxxx${transaction.receiverAcount}",
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
@Composable
fun StepIndicator1(currentStep: Int) {
    val steps = listOf("01", "02", "03")
    val titles = listOf("Amount", "Confirmation", "Payment")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        steps.forEachIndexed { index, step ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Box(
                    modifier = Modifier
                        //  .size(37.dp)
                        .padding(10.dp)
                        .background(
                            color = Color.White,
                            shape = CircleShape
                        ) // Set background color (optional)
                        .border(
                            width = 2.dp,
                            color = if (currentStep == index + 1) colorResource(id = R.color.p300) else colorResource(
                                id = R.color.g2
                            ).copy(alpha = 0.5f),
                            shape = CircleShape
                        ), // Add red border
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = step,
                        fontSize = 14.sp,
                        lineHeight = 21.sp ,
                        fontWeight = W500 ,
                        color = if (currentStep == index + 1) colorResource(id = R.color.p300) else colorResource(id = R.color.g2).copy(alpha = 0.5f),
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Text(
                    text = titles[index],
                    fontSize = 14.sp,
                    lineHeight = 21.sp ,
                    fontWeight = W500 ,
                    style = MaterialTheme.typography.bodySmall,
                    color = if (currentStep == index + 1) colorResource(id = R.color.p300) else colorResource(id = R.color.g2).copy(alpha = 0.5f)
                )


            }

            if (index < steps.size - 1) {
                Spacer(modifier = Modifier.width(6.dp))
                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .width(65.dp)
                        .background(
                            color = if (currentStep == index + 1) colorResource(id = R.color.G900) else colorResource(
                                id = R.color.G700
                            ).copy(alpha = 0.5f)

                        )
                )
                Spacer(modifier = Modifier.width(6.dp))
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