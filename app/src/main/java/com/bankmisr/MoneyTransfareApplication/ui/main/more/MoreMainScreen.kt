package com.bankmisr.MoneyTransfareApplication.ui.more

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
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bankmisr.MoneyTransfareApplication.R
@Composable
fun MoreMainScreen(
    navController: NavController
) {
    var showHelpChevron by remember {
        mutableStateOf(false)
    }

    fun OnClickHelpChevron() {
        showHelpChevron = true
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(listOf(Color(0xFFFFF8E7), Color(0xFFFFEAEE)))
            )
            .padding(top = 20.dp)
    ) {
        MoreHeader()

        MoreListItem(R.string.TransferFrom, R.drawable.website_1, true)
        MoreListItem(R.string.Favourites, R.drawable.favorite_1, true)
        MoreListItem(R.string.Profile, R.drawable.profile_1, true)

        MoreListItem(
            text = R.string.Help,
            image = R.drawable.support_1,
            showDivider = true,
            onChevronClick = ::OnClickHelpChevron // Passing the function reference
        )

        MoreListItem(R.string.Logout, R.drawable.logout_1, false)
    }

    if (showHelpChevron) {

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
            .height(56.dp),
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
    MoreMainScreen(navController = rememberNavController())
}
