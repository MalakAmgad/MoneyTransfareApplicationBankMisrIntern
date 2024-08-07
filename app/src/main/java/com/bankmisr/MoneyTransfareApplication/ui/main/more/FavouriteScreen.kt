package com.bankmisr.MoneyTransfareApplication.ui.main.more

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bankmisr.MoneyTransfareApplication.R
import com.bankmisr.MoneyTransfareApplication.database.user.Favourite
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signup1.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreen(navController: NavController,
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
                            text = "Favourites",
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
                ),
            )
        },/*floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {// addNewFavourite()
                          },
                containerColor = colorResource(id = R.color.p300),
            ) {
                Icon(
                    Icons.Filled.Add,
                    "Add note page button",
                    tint = Color.White,
                )
            }
        }
        */

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

            Text(
                text = "Yor Favourit List", // note.noteDetails,
                fontSize = 30.sp,
                lineHeight = 21.sp,
                fontWeight = W500,
                style = MaterialTheme.typography.titleMedium,
                color = colorResource(id = R.color.G900),
                textAlign = TextAlign.Justify,
                modifier = modifier
                    //.height(21.dp)
                    //.width(119.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
            )

            val  Favourites by viewModel.getAllFavourites().collectAsState(initial = emptyList())


            LazyColumn(modifier = modifier
                .padding(top = 16.dp)
                .weight(0.2f)) {
                items( Favourites.size) { index ->

                        FavouriteListItem( favourite =  Favourites[index] )
                        //{
                        //    navController.navigate("$TRANSACTIONSDetails/${transactions}")
                        //}

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteListItem(favourite: Favourite, modifier: Modifier = Modifier,viewModel: UserViewModel= viewModel()//, onNavigate: () -> Unit
) {

    Card(
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.p50)),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 4.dp)
    ) {
        var showBottomSheet by remember { mutableStateOf(false) }
        var sheetState = rememberModalBottomSheetState()
        var RecipientName by remember { mutableStateOf(favourite.fullName) }
        var RecipientAccount by remember { mutableStateOf(favourite.accountNumber) }
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
                    text = "${favourite.fullName}",
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.W500,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.p300),
                    textAlign = TextAlign.Justify,
                    modifier = modifier.wrapContentHeight(Alignment.CenterVertically)
                )
                Text(
                    text = "Account xxxx${favourite.accountNumber.toString().takeLast(4)}",
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
            Image(
                painter = painterResource(id = R.drawable.edit_1),
                colorFilter = ColorFilter.tint(colorResource(id = R.color.G100)),
                contentDescription = "Card",
                modifier = modifier
                    .clickable { showBottomSheet = true }
                    .height(18.dp)
                    .width(19.dp)
                    .padding().fillMaxHeight(), alignment = Alignment.Center
            )
            Image(
                painter = painterResource(id = R.drawable.delete_1),
                colorFilter = ColorFilter.tint(colorResource(id = R.color.D300)),
                contentDescription = "Card",
                modifier = modifier
                    .clickable { viewModel.deleteFavourite(favourite) }
                    .height(18.dp)
                    .width(19.dp)
                    .padding().fillMaxHeight(), alignment = Alignment.Center
            )

            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState, containerColor =Color.White,

                ) {

                    Row(modifier=modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Image( // Use Image composable to display the drawable
                            painter = painterResource(id = R.drawable.edit_1),
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.p300)),
                            contentDescription = "Card", modifier = modifier
                                .rotate(180f)
                                .height(20.dp)
                                .width(20.dp)
                                .padding()
                        )
                        Text(
                            text = "Edit",
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.W400,
                            style = MaterialTheme.typography.titleMedium,
                            color = colorResource(id = R.color.p300),
                            textAlign = TextAlign.Center,
                            modifier = modifier//.fillMaxWidth()
                                .padding(2.dp)
                        )
                    }
                    Column (modifier = modifier.padding(10.dp)){

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
                                value = RecipientAccount.toString(),
                                onValueChange = { newValue ->
                                    RecipientAccount = newValue.toLongOrNull() ?: RecipientAccount
                                },
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
                                value = RecipientName,
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
                        Button(
                            enabled = RecipientName.isNotBlank() && RecipientAccount != 0L,
                            onClick = {
                                viewModel.upserFavourite(
                                    Favourite(
                                        id = favourite.id,
                                        fullName = RecipientName,
                                        accountNumber = RecipientAccount
                                    )
                                )

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


                    }

                }
            }

        }
    }
}



    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun addNewFavourite() {
        var viewModel: UserViewModel = viewModel()
        var showBottomSheet by remember { mutableStateOf(false) }
        var sheetState = rememberModalBottomSheetState()
        var recipientName by remember { mutableStateOf("") }
        var recipientAccount by remember { mutableStateOf("") }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState
            ) {
                Column {
                    // Title or Icon for Add New Favourite (Optional)

                    OutlinedTextField(
                        value = recipientAccount,
                        onValueChange = { recipientAccount = it },
                        label = { Text("Recipient Account Number") }
                    )

                    OutlinedTextField(
                        value = recipientName,
                        onValueChange = { recipientName = it },
                        label = { Text("Recipient Name") }
                    )

                    Button(
                        onClick = {
                            val accountNumber = recipientAccount.toLongOrNull() ?: 0L
                            if (recipientName.isNotBlank() && accountNumber != 0L) {
                                viewModel.upserFavourite(
                                    Favourite(
                                        fullName = recipientName,
                                        accountNumber = accountNumber
                                    )
                                )
                            }
                            showBottomSheet = false
                        },
                        enabled = recipientName.isNotBlank() && recipientAccount.isNotEmpty(),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Add Favourite")
                    }
                }
            }
        }

        // Trigger to show the bottom sheet (e.g., a FloatingActionButton)
        Button(onClick = { showBottomSheet = true }) {
            Text("Add New Favourite")
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