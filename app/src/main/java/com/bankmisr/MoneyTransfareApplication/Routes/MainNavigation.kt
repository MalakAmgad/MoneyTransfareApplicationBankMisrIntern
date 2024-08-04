package com.bankmisr.MoneyTransfareApplication.Routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bankmisr.MoneyTransfareApplication.ui.main.transfare.Transfare1Screen
import com.bankmisr.MoneyTransfareApplication.ui.main.transfare.Transfer2
import com.bankmisr.MoneyTransfareApplication.ui.main.transfare.TransferMainScreen

object MainRout {

    const val HOME="home"
    const val TRANSACTIONS="transactions"
    const val TRANSACTIONSDetails="transactionsDetails"
    const val TRANSFARE="transfare"
    const val MYCARDS="mycards"
    const val MORE="more"
    const val NOTIFICATION="notififcation"
    const val SERVERERROR="servererror"
    const val TRANSFARE1="transfare1"
}


@Composable
fun MainNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MainRout.HOME ){

        composable(MainRout.HOME){
            TransferMainScreen(navController =navController )
        }

        composable(MainRout.TRANSFARE){
            Transfare1Screen(navController = navController)
        }

    }
}