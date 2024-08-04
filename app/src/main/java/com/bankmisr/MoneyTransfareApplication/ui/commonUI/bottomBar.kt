package com.bankmisr.MoneyTransfareApplication.ui.commonUI

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bankmisr.MoneyTransfareApplication.R
import com.bankmisr.MoneyTransfareApplication.Routes.Route.HOME
import com.bankmisr.MoneyTransfareApplication.Routes.Route.MORE
import com.bankmisr.MoneyTransfareApplication.Routes.Route.MYCARDS
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SIGNUP2
import com.bankmisr.MoneyTransfareApplication.Routes.Route.TRANSACTIONS
import com.bankmisr.MoneyTransfareApplication.Routes.Route.TRANSFARE
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signup1.UserViewModel

@Composable
fun bottomBar(navController: NavController,
              modifier: Modifier = Modifier,
              viewModel: UserViewModel = viewModel()
) {
    optionslList(options = DataSource().getoptionsData(), navController = navController, viewModel = viewModel)
}


@Composable
fun optionslList(options: List<option>,modifier: Modifier = Modifier,navController: NavController, viewModel: UserViewModel ) {
    val selectedIndex = viewModel.selectedIndex
    BottomAppBar(
        containerColor = Color.White,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart =24.dp, topEnd = 24.dp))
           // .padding(8.dp)
    ){LazyRow(modifier = modifier.padding(start = 20.dp)) {
        items(options.size) { index -> // Iterate using indices
            item(option = options[index], index = index, selectedIndex = selectedIndex, navController = navController,viewModel = viewModel)
        }
    }}
}

@Composable
fun item(option: option, index: Int, selectedIndex: MutableState<Int?>, modifier: Modifier = Modifier,navController: NavController,viewModel: UserViewModel ) {
    val isSelected = selectedIndex.value == index

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.clickable {
                viewModel.updateSelectedIndex(index)
                navController.navigate(option.navigation)
            }.fillMaxWidth()

        ){
                Column(

                    modifier = modifier.padding(horizontal = 8.dp),
                    Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Image(
                        painter = painterResource(id = option.picture),
                        contentDescription =  option.name
                        , modifier = modifier
                            .size(24.dp),
                       // modifier = modifier.height(4.19.dp).width(1.9.dp),
                       colorFilter = ColorFilter.tint(
                           if (viewModel.selectedIndex.value == index) colorResource(id = R.color.p300) else colorResource(id = R.color.G200))
                    )
                        Text(
                            text = option.name,
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 18.sp,
                            textAlign = TextAlign.Center,
                            modifier = modifier.padding(4.dp),
                            color = if (viewModel.selectedIndex.value == index) colorResource(id = R.color.p300) else colorResource(id = R.color.G200)
                        )
                    }

        }

}


class DataSource {
    fun getoptionsData(): List<option> {
        val options = mutableListOf<option>()
        options.add(
            option(
                "Home",
                R.drawable.home_1,
                SIGNUP2
            )
        )
        options.add(
            option(
                "Transfare",
                R.drawable.transfer_1,
                TRANSFARE
            )
        )
        options.add(
            option(
                "Transactions",
                R.drawable.history_1,
                TRANSACTIONS
            )
        )
        options.add(
            option(
                "My cards",
                R.drawable.cards_1,
                MYCARDS
            )
        )
        options.add(
            option(
                "More",
                R.drawable.more_1,
                MORE
            )
        )
        return options
    }

}
data class option(val name: String,
                  @DrawableRes val picture: Int,
                  val navigation: String
)

/*
@Preview
@Composable
private fun preview() {
    item(option = DataSource().getoptionsData()[0])
}*/
