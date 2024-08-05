package com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signup1

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bankmisr.MoneyTransfareApplication.R
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SIGNIN
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SIGNUP
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SIGNUP2
import com.bankmisr.MoneyTransfareApplication.database.user.User
import com.bankmisr.MoneyTransfareApplication.models.register
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.RegisterViewModel


@Composable
fun SignUp1(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel = viewModel()

) {

    val registrationResponse by viewModel.registrationResponse.observeAsState()

    val context = LocalContext.current
    var FullName by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    var Password by remember { mutableStateOf("") }
    var passwordVisible = remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
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


            }
        }

    ) { innerPadding ->
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


            Column(
                verticalArrangement = Arrangement.Center,
                modifier = modifier.padding(top = 55.dp, bottom = 25.dp)
            ) {
                Text(
                    text = "Sign Up",
                    color = colorResource(id = R.color.G900),
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 30.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(44.dp))
                Text(
                    text = "Speedo Transfer ",
                    color = colorResource(id = R.color.G900),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 29.05.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            Column(

                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp), verticalArrangement = Arrangement.spacedBy(18.dp)

            ) {

                Text(
                    text = "Full Name",
                    modifier = Modifier.padding(top = 5.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 24.sp,
                    textAlign = TextAlign.Left,
                    color = colorResource(id = R.color.G700)
                )


                OutlinedTextField(
                    value = FullName,
                    onValueChange = { FullName = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.white)),
                    placeholder = {
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
                            painter = painterResource(id = R.drawable.user1),
                            contentDescription = "User Icon",
                            tint = colorResource(id = R.color.G70)
                        )
                    }
                )
                //  Spacer(modifier = modifier.padding(5.dp))

                Text(
                    text = "Email",
                    modifier = Modifier.padding(top = 5.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 24.sp,
                    textAlign = TextAlign.Left,
                    color = colorResource(id = R.color.G700)
                )


                OutlinedTextField(
                    value = Email,
                    onValueChange = { Email = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.white)),
                    placeholder = {
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
                    modifier = Modifier.padding(top = 5.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 24.sp,
                    textAlign = TextAlign.Left,
                    color = colorResource(id = R.color.G700)
                )


                OutlinedTextField(
                    value = Password,
                    onValueChange = { newPassword ->
                        Password = newPassword
                        passwordError = !isValidPassword(newPassword)
                    },
                    isError = passwordError,
                    visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
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
                            painterResource(id = R.drawable.close_eye)
                        } else {
                            painterResource(id = R.drawable.open_eye)
                        }
                        Icon(
                            painter = image,
                            contentDescription = if (passwordVisible.value) "Hide password" else "Show password",
                            tint = colorResource(id = R.color.G70),
                            modifier = Modifier.clickable {
                                passwordVisible.value = !passwordVisible.value
                            }
                        )


                    }
                )
                if (passwordError) {
                    Text(
                        text = "Your password must contain at least 6 characters, one lowercase," +
                                " one uppercase letter and one special character",
                        color = colorResource(id = R.color.p300)
                    )
                }


                val isFullName = (FullName.contains(" "))
                //   Spacer(modifier = modifier.padding(5.dp))
                Button(
                    enabled = isValidPassword(Password) && isFullName,
                    onClick = {
                        // viewModel.upsert(User(fullName = FullName,email = Email,password = Password))
                        //FullName,Email,Password,SIGNUP2
                        // saveCredentials(Email, Password, context)
                        navController.navigate("$SIGNUP2/${FullName}/${Email}/${Password}")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(343.dp)
                        .height(60.dp)
                        .padding(top = 10.dp),
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.marron))
                ) {
                    Text(
                        text = "Sign up", color = colorResource(id = R.color.white),
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 21.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = colorResource(id = R.color.G100),
                                    fontFamily = FontFamily.SansSerif, // Or use a custom font if needed
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.W400
                                )
                            ) {
                                append(
                                    stringResource(
                                        id = R.string.have_account,
                                        stringResource(id = R.string.already), ""
                                    )
                                )
                            }

                            withStyle(
                                SpanStyle(
                                    color = colorResource(id = R.color.marron),
                                    fontFamily = FontFamily.SansSerif, // Or use a custom font if needed
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.W400,
                                    textDecoration = TextDecoration.Underline,

                                    )
                            ) {
                                append(
                                    stringResource(
                                        id = R.string.have_account,
                                        "", stringResource(id = R.string.signin), ""
                                    )
                                )
                            }
                        }, modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(SIGNIN)
                            }, // Make Text fill the Column width
                        textAlign = TextAlign.Center // Center text within the Text composable

                    )

                }

            }


        }

    }
}


fun isValidPassword(password: String): Boolean {
    return password.length >= 6 &&
            password.any { it.isLowerCase() } &&
            password.any { it.isUpperCase() } &&
            password.any { !it.isLetterOrDigit() }
}


@Preview
@Composable
private fun signUp1Preview() {
    SignUp1(rememberNavController())
}