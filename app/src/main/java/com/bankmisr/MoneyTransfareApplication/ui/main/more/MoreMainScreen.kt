package com.bankmisr.MoneyTransfareApplication.ui.more

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bankmisr.MoneyTransfareApplication.R
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SIGNIN
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreMainScreen(
    navController: NavController,
    appNavController: NavController
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    val number = "19888"
    val context = LocalContext.current
    fun onClickHelp() {
        showBottomSheet = true
    }

    var openAlertDialog by remember { mutableStateOf(false) }

    fun onClickLogout() {

    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE)))
            )
            .padding(top = 50.dp)
    ) {
        MoreHeader()
        MoreListItem(R.string.TransferFrom, R.drawable.website_1, true)
        MoreListItem(R.string.Favourites, R.drawable.favorite_1, true)
        MoreListItem(R.string.Profile, R.drawable.profile_1, true)

        MoreListItem(
            text = R.string.Help,
            image = R.drawable.support_1,
            showDivider = true,
            onChevronClick = ::onClickHelp
        )
        MoreListItem(R.string.Logout, R.drawable.logout_1, false, onChevronClick = {
            openAlertDialog = true
        })
    }

    if (openAlertDialog) {
        AlertDialog(
            onDismissRequest = { openAlertDialog = false },
            title = { Text(text = stringResource(id = R.string.Logout))},
            confirmButton = {
                Button(
                    onClick = {
                        appNavController.navigate(SIGNIN) {
                            popUpTo(0) { inclusive = true }
                            launchSingleTop = true
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.p300))
                ) {
                    Text(text = stringResource(id = R.string.Logout))
                }

            },
            dismissButton = {
                Button(
                    onClick = { openAlertDialog = false },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.p300))
                ) {
                    Text(text = stringResource(R.string.dismiss))
                }
            }

        )
    }



    if (showBottomSheet) {
        Surface(
            color = Color.White
        ) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {

                    ElevatedCard(
                        modifier = Modifier
                            .width(120.dp)
                            .height(139.dp)
                            .clickable {
                                context.sendMail(
                                    to = "example@gmail.com",
                                    subject = "Some subject"
                                )
                            },
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = colorResource(id = R.color.p50)
                        )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.email_1),
                                    contentDescription = stringResource(id = R.string.Photo),
                                    Modifier
                                        .height(55.dp)
                                        .width(55.dp)
                                )
                                Text(text = "Send Email")
                            }
                        }
                    }

                    ElevatedCard(
                        modifier = Modifier
                            .width(120.dp)
                            .height(139.dp)
                            .clickable {
                                val u = Uri.parse("tel:$number")

                                val i = Intent(Intent.ACTION_DIAL, u)
                                try {
                                    context.startActivity(i)
                                } catch (s: SecurityException) {

                                    Toast
                                        .makeText(
                                            context,
                                            "An error occurred",
                                            Toast.LENGTH_LONG
                                        )
                                        .show()
                                }
                            },
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = colorResource(id = R.color.p50)
                        ),

                        ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.call_1),
                                    contentDescription = stringResource(id = R.string.Photo),
                                    Modifier
                                        .height(55.dp)
                                        .width(55.dp)
                                )
                                Text(text = "Call us")
                            }

                        }
                    }
                }
            }
        }
    }
}

fun Context.sendMail(to: String, subject: String) {
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "vnd.android.cursor.item/email" // or "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        // TODO: Handle case where no email app is available //i need to fix this
    } catch (t: Throwable) {
        // TODO: Handle potential other type of exceptions
    }
}

@Composable
fun MoreHeader() {
    /*   Image(   //uncomment to add back arrow
           painter = painterResource(id = ),
           contentDescription = "Card"
       )*/



    Text(text = "More", fontSize = 25.sp)


}

@Composable
fun MoreListItem(
    text: Int,
    image: Int,
    showDivider: Boolean,
    onChevronClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onChevronClick?.invoke() },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(id = R.string.Photo),
            modifier = Modifier
                .height(30.dp)
                .width(30.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = stringResource(id = text), fontSize = 20.sp)

        Spacer(modifier = Modifier.weight(1f)) // Takes up the remaining space

        Image(
            painter = painterResource(id = R.drawable.ic_next_chevron),
            contentDescription = stringResource(id = R.string.Photo),
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .clickable(onClick = {
                    onChevronClick?.invoke() // Invoke the function if it's not null
                })
        )
    }
    if (showDivider) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 10.dp),
            thickness = 0.6.dp,
            color = androidx.compose.ui.graphics.Color.LightGray
        )
    }
}


@Composable
@Preview
fun MoreMainScreenPreview() {
    MoreMainScreen(
        navController = rememberNavController(),
        appNavController = rememberNavController()
    )
}
