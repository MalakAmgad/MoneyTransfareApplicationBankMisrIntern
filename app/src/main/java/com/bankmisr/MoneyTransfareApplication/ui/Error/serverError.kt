package com.bankmisr.MoneyTransfareApplication.ui.Error


import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bankmisr.MoneyTransfareApplication.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun serverError(modifier: Modifier = Modifier, navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.seashell)
                )
            )
        }
    ) { _ ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            colorResource(id = R.color.seashell),
                            colorResource(id = R.color.pastel)
                        ),
                        end = Offset(0f, Float.POSITIVE_INFINITY)
                    )
                )
                .padding(horizontal = 10.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(263.dp)//.weight(0.25f)
                    //.shadow(elevation = 4.dp, clip = true)
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(painter =  painterResource(id = R.drawable._04_error),
                    contentDescription = "status" )
            }

            Text(
                text ="Server error..." , // note.noteDetails,
                fontSize = 24.sp,
                lineHeight = 36.sp ,
                fontWeight = W500 ,
                style = MaterialTheme.typography.bodyMedium ,
                color = colorResource(id = R.color.G900),
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .padding(10.dp)
                  //  .height(21.dp)
                  //  .width(119.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
            )
            Text(
                text ="It seems like we’re haveing some diffculities , please don’t leave your aspirations, we are sending for help" , // note.noteDetails,
                fontSize = 16.sp,
                lineHeight = 24.sp ,
                fontWeight = W400 ,
                style = MaterialTheme.typography.bodyMedium ,
                color = colorResource(id = R.color.G700),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(10.dp)
                //    .height(21.dp)
                //    .width(119.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
            )
            val phoneNumber= "0000"
            Button(
                onClick = {
                     Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .width(343.dp)
                    .height(60.dp)
                    .padding(top = 10.dp)
                ,
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.marron))
            ) {
                Text(text ="Call Us",color = colorResource(id = R.color.white),
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 21.sp,
                    textAlign = TextAlign.Center )
            }
            var buttonClicked by remember { mutableStateOf(false) }
            Button(
                onClick = {
                    buttonClicked = !buttonClicked
                    val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
                    val message = "Server error occurred at [$timestamp] Please help!" // Replace with yourmessage

                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("smsto:$phoneNumber")  // This ensures only SMS apps handle the intent
                        putExtra("sms_body", message)  // Adds the pre-filled message
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .width(343.dp)
                    .height(60.dp)
                    .padding(top = 10.dp).border(
                        width = 2.dp, // Adjust border width as needed
                        color =   colorResource(id = R.color.marron),
                        shape = RoundedCornerShape(6.dp)
                    )
                ,
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(
                if   (buttonClicked)  colorResource(id = R.color.marron) else Color.Transparent

                )
            ) {
                    Text(text ="Massage Us",color =if (buttonClicked) colorResource(id = R.color.white)else colorResource(id = R.color.marron),
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 21.sp,
                    textAlign = TextAlign.Center )
            }


        }

    }
}
