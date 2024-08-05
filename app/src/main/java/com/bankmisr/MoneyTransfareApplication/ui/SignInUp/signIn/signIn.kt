package com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signIn


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bankmisr.MoneyTransfareApplication.R
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SIGNUP
import com.bankmisr.MoneyTransfareApplication.database.user.User
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signup1.UserViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.bankmisr.MoneyTransfareApplication.Routes.MainRout
import com.bankmisr.MoneyTransfareApplication.Routes.Route.MAIN_SCREEN
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signup1.isValidPassword
import com.bankmisr.MoneyTransfareApplication.ui.theme.MoneyTransfareApplicationTheme



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun signInScreen (
   // email:String?,password:String?,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel()

) {

  //  val users by viewModel.getNotes().collectAsState(initial = emptyList())
  //  val userDefault =users.last()
    val context = LocalContext.current
    val prefs = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
    val userEmail  = prefs.getString("email", "")!!
    val userPassword = prefs.getString("password", "")!!

   // val userDefault: User? = viewModel.getLastUser()

   // val userEmail = remember(userDefault){ userDefault?.email ?: "" }
   // val userPassword = remember(userDefault) { userDefault?.password ?: "" }
    var Email by remember { mutableStateOf(userEmail) }
    var Password by remember { mutableStateOf(userPassword) }

    Log.d("trace", "signInScreen: $Email $Password")
/*
    var Email by remember { mutableStateOf("") }
    var Password by remember { mutableStateOf("") }
*/

    var passwordVisible = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Sign In",
                        color = colorResource(id = R.color.G900),
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 30.sp,
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
        , bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp), // Adjust bottom padding as needed
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { /* Your button click logic here */ },
                    modifier = Modifier
                        .width(134.dp)
                        .height(48.dp) // Assuming you meant 48px for height
                        .alpha(0f), // Opacity 0 (invisible)
                    shape = RoundedCornerShape(
                        topStart = 2.5.dp,
                        topEnd = 0.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent // No background color
                    )
                ) {
                    // You can leave this emptysince it's just a rectangular shape
                }


            }}

    ) {
            innerPadding->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            colorResource(id = R.color.white),
                            colorResource(id = R.color.lightPink)
                        ),
                        end = Offset(0f, Float.POSITIVE_INFINITY)
                    )
                )
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Column( verticalArrangement =Arrangement.Center , modifier = modifier.padding(innerPadding) ){
                Text(
                    text = "Speedo Transfer ",
                    color = colorResource(id = R.color.G900),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 29.05.sp,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier.fillMaxSize()
                  .padding( 16.dp)
                , verticalArrangement = Arrangement.spacedBy(18.dp)

            ) {
                    Text(
                        text = "Email",
                        modifier = Modifier.padding(top=5.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        lineHeight = 24.sp,
                        textAlign = TextAlign.Left,
                        color = colorResource(id = R.color.G700)
                    )


                    OutlinedTextField(
                        value = Email,
                        onValueChange = { Email=it },
                        modifier = Modifier.fillMaxWidth()
                        //    .width(343.dp)
                        //    .height(54.dp)
                            .background(colorResource(id = R.color.white)),
                        placeholder= {
                            Text(
                                "Enter your Full Name",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400,
                                lineHeight = 21.sp,
                                color = colorResource(id = R.color.G70)
                            )
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.email_1),
                                contentDescription = "User Icon",
                                tint = colorResource(id = R.color.G70)
                            )
                        }
                    )

                //  Spacer(modifier = modifier.padding(5.dp))

                    Text(
                        text = "Password",
                        modifier = Modifier.padding(top=5.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        lineHeight = 24.sp,
                        textAlign = TextAlign.Left,
                        color = colorResource(id = R.color.G700)
                    )


                    OutlinedTextField(
                        value = Password,
                        onValueChange = { Password=it },
                        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                            //    .width(343.dp)
                            //    .height(54.dp)
                            .background(colorResource(id = R.color.white)),
                        placeholder = {
                            Text(
                                "Enter your Password",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400,
                                lineHeight = 21.sp,
                                color = colorResource(id = R.color.G70)
                            )
                        },
                        trailingIcon = {
                            val image = if (passwordVisible.value) {
                                painterResource(id = R.drawable.open_eye)
                            } else {
                                painterResource(id = R.drawable.close_eye)
                            }
                            Icon(
                                painter = image,
                                contentDescription = if (passwordVisible.value) "Hide password" else "Show password",
                                tint = colorResource(id = R.color.G70),
                                modifier = Modifier.clickable {
                                    passwordVisible.value = !passwordVisible.value}
                            )

                        }
                    )

                //   Spacer(modifier = modifier.padding(5.dp))
                Button(
                    onClick = { viewModel.loginUser(Email, Password)
                        //      if(viewModel.success){
                                  navController.navigate(MAIN_SCREEN)
                        //      }
                        //else{ Toast.makeText(context, "Wrong login or password ", Toast.LENGTH_SHORT).show();  }
                              }
                    ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(343.dp)
                        .height(60.dp)
                        .padding(top = 10.dp)
                    ,
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.marron))
                ) {
                    Text(text ="Sign In",color = colorResource(id = R.color.white),
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 21.sp,
                        textAlign = TextAlign.Center )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally, ){
                    Text(
                        text=buildAnnotatedString {
                            withStyle(SpanStyle(color = colorResource(id = R.color.G100),
                                fontFamily = FontFamily.SansSerif, // Or use a custom font if needed
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W400
                            )
                            ) {
                                append(
                                    stringResource(
                                        id = R.string.have_account,
                                        stringResource(id = R.string.Dont), ""
                                    )
                                )
                            }

                            withStyle(SpanStyle(color = colorResource(id = R.color.marron),
                                fontFamily = FontFamily.SansSerif, // Or use a custom font if needed
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W400,
                                textDecoration = TextDecoration.Underline,

                                )){
                                append(
                                    stringResource(
                                        id = R.string.have_account,
                                        "", stringResource(id = R.string.signup)
                                    )
                                )
                            }
                        },modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(SIGNUP)
                            },
                        textAlign = TextAlign.Center

                    )

                }

            }

        }

    }
}




/*

@Preview
@Composable
private fun signInPreview() {
    signIn()
}*/