package com.bankmisr.MoneyTransfareApplication.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bankmisr.MoneyTransfareApplication.R
import com.bankmisr.MoneyTransfareApplication.Routes.MainNavigation
import com.bankmisr.MoneyTransfareApplication.models.BottomNavigationItem

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
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