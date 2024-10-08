package com.bankmisr.MoneyTransfareApplication.Routes

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bankmisr.MoneyTransfareApplication.database.Transaction
import com.bankmisr.MoneyTransfareApplication.ui.main.MainNavigationBar
import com.bankmisr.MoneyTransfareApplication.ui.main.Transaction.TransactionDetailsScreen
import com.bankmisr.MoneyTransfareApplication.ui.main.Transaction.TransactionsScreen
import com.bankmisr.MoneyTransfareApplication.ui.main.home.HomeScreen
import com.bankmisr.MoneyTransfareApplication.ui.main.home.notifications.NotificationScreen
import com.bankmisr.MoneyTransfareApplication.ui.main.more.FavouriteScreen
import com.bankmisr.MoneyTransfareApplication.ui.main.myCards.MyCardsScreen
import com.bankmisr.MoneyTransfareApplication.ui.main.transfare.TransferConfirmationScreen
import com.bankmisr.MoneyTransfareApplication.ui.main.transfare.TransferPaymentScreen
import com.bankmisr.MoneyTransfareApplication.ui.main.transfare.TransferScreen
import com.bankmisr.MoneyTransfareApplication.ui.more.MoreMainScreen

object MainRout {

    const val HOME = "home"
    const val TRANSACTIONS = "Transactions"
    const val TRANSACTIONSDetails = "transactionsDetails"
    const val TRANSFARE = "Transfer"
    const val MYCARDS = "My cards"
    const val MORE = "More"
    const val NOTIFICATION = "notififcation"
    const val SERVERERROR = "servererror"
    const val TRANSFARECONFIRMATION = "transfareConfirmation"
    const val TRANSFAREPAYMENT = "transfarepayment"
    const val FAVOURITE = "favourite"
}


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    appNavController: NavController
) {

    val navController = rememberNavController()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            MainNavigationBar(navController)
        }
    ) {
        NavHost(navController = navController, startDestination = MainRout.HOME) {

            composable(MainRout.HOME) {
                HomeScreen(navController = navController)
            }

            composable(MainRout.TRANSFARE) {
                TransferScreen(navController = navController)
            }

            composable(MainRout.TRANSACTIONS) {
                TransactionsScreen(navController = navController)
            }

            composable(MainRout.MYCARDS) {
                MyCardsScreen(navController = navController)
            }

            composable(MainRout.MORE) {
                MoreMainScreen(navController = navController, appNavController = appNavController)
            }

            composable(route="${MainRout.TRANSFARECONFIRMATION}/{refrence}" ,
                arguments = listOf (navArgument("refrence") { type = NavType.LongType })) {

                val refrence = it.arguments?.getLong ("refrence")!!
                TransferConfirmationScreen(refrence = refrence, navController = navController)

            }

            composable(route="${MainRout.TRANSFAREPAYMENT}/{refrence}" ,
                arguments = listOf (navArgument("refrence") { type = NavType.LongType })) {

                val refrence = it.arguments?.getLong ("refrence")!!
                TransferPaymentScreen(refrence = refrence, navController = navController)

            }

            composable(MainRout.NOTIFICATION) {
                NotificationScreen(navController = navController)
            }
            composable("${MainRout.TRANSACTIONSDetails}/{refrence}" ,
                arguments = listOf (navArgument("refrence") { type = NavType.LongType })) {

                val refrence = it.arguments?.getLong ("refrence")!!
                TransactionDetailsScreen(refrence = refrence, navController = navController)
            }
            composable(MainRout.FAVOURITE) {
                FavouriteScreen(navController = navController)
            }

        }
    }
}