package com.bankmisr.MoneyTransfareApplication.Routes

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bankmisr.MoneyTransfareApplication.Routes.Route.MAIN_SCREEN
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SIGNIN
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SIGNUP
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SIGNUP2
import com.bankmisr.MoneyTransfareApplication.Routes.Route.TRANSFARE1
import com.bankmisr.MoneyTransfareApplication.ui.Error.connectionError
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signIn.SignInScreen
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signUp2.signUp2
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signup1.SignUp1
import com.bankmisr.MoneyTransfareApplication.ui.main.IdleViewModel
import com.bankmisr.MoneyTransfareApplication.ui.main.MainScreen
object Route {
    const val SIGNIN = "SignUp"
    const val SIGNUP = "SignIn"
    const val SIGNUP2 = "signUp2"
    const val HOME = "home"
    const val TRANSACTIONS = "transactions"
    const val TRANSACTIONSDetails = "transactionsDetails"
    const val TRANSFARE = "transfare"
    const val MYCARDS = "mycards"
    const val MORE = "more"
    const val NOTIFICATION = "notififcation"
    const val SERVERERROR = "servererror"
    const val TRANSFARE1 = "transfare1"
    const val MAIN_SCREEN = "MainScreen"
    const val INTERNET = "internet"
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun ApppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SIGNIN) {
        composable(route = SIGNIN) { SignInScreen(navController = navController) }
        composable(route = SIGNUP) { SignUp1(navController = navController) }

        composable(MAIN_SCREEN) {
           var idleViewModel: IdleViewModel= viewModel()
            MainScreen(appNavController = navController, idleViewModel = idleViewModel
            )
        }

        composable(route = "$SIGNUP2/{fullname}/{email}/{password}",
            arguments = listOf(
                navArgument("fullname") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            )) {
            val fullname = it.arguments?.getString("fullname")!!
            val email = it.arguments?.getString("email")!!
            val password = it.arguments?.getString("password")!!
            signUp2(fullname, email, password, navController = navController)
        }
        composable(route = Route.INTERNET) { connectionError(navController = navController) }

    }


}