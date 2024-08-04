package com.bankmisr.MoneyTransfareApplication.Routes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bankmisr.MoneyTransfareApplication.ui.main.MainNavigationBar
import com.bankmisr.MoneyTransfareApplication.ui.main.Transaction.TransactionsScreen
import com.bankmisr.MoneyTransfareApplication.ui.main.home.HomeScreen
import com.bankmisr.MoneyTransfareApplication.ui.main.myCards.MyCardsScreen
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
    const val TRANSFARE1 = "transfare1"
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainNavigation(modifier: Modifier = Modifier) {

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
                MoreMainScreen(navController = navController)
            }

        }
    }
}