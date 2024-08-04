package com.bankmisr.MoneyTransfareApplication.ui.main

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bankmisr.MoneyTransfareApplication.R
import com.bankmisr.MoneyTransfareApplication.Routes.MainNavigation
import com.bankmisr.MoneyTransfareApplication.models.BottomNavigationItem

import androidx.compose.runtime.*
import kotlinx.coroutines.delay

@Composable
fun MainScreen(
    modifier: Modifier = Modifier//,onUserActivity: () -> Unit
) {
    
        MainNavigation()

}


//@Preview
//@Composable
//private fun MainScreenPreview() {
//    MainScreen(navController = rememberNavController())
//}




@Composable
fun MainNavigationBar(navController: NavController, modifier: Modifier = Modifier) {

    val navigationItems = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = R.drawable.home_1,
        ),
        BottomNavigationItem(
            title = "Transfer",
            selectedIcon = R.drawable.transfer_1,
        ),
        BottomNavigationItem(
            title = "Transactions",
            selectedIcon = R.drawable.history_1,
        ),
        BottomNavigationItem(
            title = "My cards",
            selectedIcon = R.drawable.cards_1,
        ),
        BottomNavigationItem(
            title = "More",
            selectedIcon = R.drawable.more_1,
        ),

        )

    var selectedItemIndex by remember {
        mutableStateOf(0)
    }

    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp))
            .background(Color.White),
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.title)
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 10.1.sp,
                        overflow = TextOverflow.Visible,
                        maxLines = 1,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White,
                    selectedIconColor = colorResource(id = R.color.p300),
                    unselectedIconColor = colorResource(id = R.color.G100),
                    selectedTextColor = colorResource(id = R.color.p300),
                    unselectedTextColor = colorResource(id = R.color.G100)
                ),
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = item.selectedIcon),
                        contentDescription = item.title,
                    )
                },

                )
        }
    }
}

/*
@Composable
fun InactivityHandler() {
    var lastActivityTime by remember { mutableStateOf(System.currentTimeMillis()) }
    var showDialog by remember { mutableStateOf(false) }


    LaunchedEffect(Unit) {
        while (true) {
            delay(60000L) // 1 minute
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastActivityTime > 1*1000L //30 * 60 * 1000L

                ) { // 30 minutes
                showDialog = true
            }
        }
    }

    // Call this function whenever there is user activity
    fun updateLastActivityTime() {
        lastActivityTime = System.currentTimeMillis()
    }


    MainScreen(onUserActivity = { updateLastActivityTime() })

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { /* Do nothing to force the user to take action */ },
            title = { Text(text = "Session Timeout") },
            text = { Text("You have been inactive for 30 minutes. Please log in again.") },
            confirmButton = {
                Button(onClick = {
                    showDialog = false
                    // Navigate to the login screen

                }) {
                    Text("OK")
                }
            }
        )
    }
}
*/