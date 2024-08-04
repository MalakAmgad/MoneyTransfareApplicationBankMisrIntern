package com.bankmisr.MoneyTransfareApplication.Routes

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bankmisr.MoneyTransfareApplication.Routes.Route.NOTIFICATION
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SERVERERROR
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SIGNIN
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SIGNUP
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SIGNUP2
import com.bankmisr.MoneyTransfareApplication.Routes.Route.TRANSACTIONS
import com.bankmisr.MoneyTransfareApplication.Routes.Route.TRANSACTIONSDetails
import com.bankmisr.MoneyTransfareApplication.Routes.Route.TRANSFARE
import com.bankmisr.MoneyTransfareApplication.Routes.Route.TRANSFARE1
import com.bankmisr.MoneyTransfareApplication.database.Transaction
import com.bankmisr.MoneyTransfareApplication.ui.Error.serverError
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signIn.signInScreen
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signUp2.signUp2
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signup1.signUp1
import com.bankmisr.MoneyTransfareApplication.ui.main.Transaction.Transactions
import com.bankmisr.MoneyTransfareApplication.ui.main.Transaction.transactionDetails
import com.bankmisr.MoneyTransfareApplication.ui.main.home.notifications.Notifications
import com.bankmisr.MoneyTransfareApplication.ui.main.transfare.Transfare1Screen
import com.bankmisr.MoneyTransfareApplication.ui.main.transfare.TransferMainScreen

object Route {
    const val SIGNIN = "SignUp"
    const val SIGNUP = "SignIn"
    const val SIGNUP2 = "signUp2"
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

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun ApppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = TRANSFARE1) {
        composable(route = SIGNIN){ signInScreen(navController = navController)}
        composable(route = SIGNUP){ signUp1(navController = navController) }
       // composable(route = SIGNUP2){ signUp2(navController = navController) }
        composable(route = TRANSACTIONS){ Transactions(navController = navController) }
        composable(route = NOTIFICATION){ Notifications(navController = navController) }
        composable(route = SERVERERROR){ serverError(navController = navController) }
        composable(route = TRANSFARE){ TransferMainScreen(navController = navController) }
        composable(route = TRANSFARE1){ Transfare1Screen(navController = navController) }
      //  composable(route = TRANSACTIONSDetails){ transactionDetails(navController = navController) }

        composable(route = "$TRANSACTIONSDetails/{transaction}") { backStackEntry ->
            val transaction = backStackEntry.arguments?.getParcelable<Transaction>("transaction", Transaction::class.java)//!!

                transactionDetails(transaction = transaction, navController = navController)

        }

        composable(route = "$SIGNUP/{fullname}/{email}/{password}",
            arguments = listOf(
                navArgument("fullname"){type= NavType.StringType},
                navArgument("email"){type= NavType.StringType},
                navArgument("password"){type= NavType.StringType}
            )){
            val fullname =it.arguments?.getString("fullname")!!
            val email =it.arguments?.getString("email")!!
            val password =it.arguments?.getString("password")!!
            signUp2(fullname,email,password,navController = navController)}

    }


}