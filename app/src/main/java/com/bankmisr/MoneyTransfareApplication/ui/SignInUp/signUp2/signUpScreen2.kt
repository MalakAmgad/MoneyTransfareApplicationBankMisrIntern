package com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signUp2


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bankmisr.MoneyTransfareApplication.R
import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SIGNIN
import com.bankmisr.MoneyTransfareApplication.Routes.Route.SIGNUP2
import com.bankmisr.MoneyTransfareApplication.models.register
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.RegisterViewModel
import com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signup1.UserViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun signUp2 (
    fullname:String,email:String,password:String,
             navController: NavController,
             modifier: Modifier = Modifier,
             viewModel: RegisterViewModel = viewModel()
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf("Select your country") }
    var country by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("DD/MM/YYYY") }
    var showDatePicker by remember { mutableStateOf(false) }
    var context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Icon(
                        painter = painterResource(id = R.drawable.drop_down_1),
                        contentDescription = "Back",modifier = Modifier.clickable {
                            navController.popBackStack()
                        }

                        )
                }
            )
        },
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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Column( verticalArrangement =Arrangement.Top, modifier = modifier
                .weight(0.15f)
                .padding(top = 30.dp) ){
                Text(
                    text = "Speedo Transfer ",
                    color = colorResource(id = R.color.G900),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 29.05.sp,
                    textAlign = TextAlign.Center
                )
            }
            Column( verticalArrangement =Arrangement.Center  ){
                Text(
                    text = "Welcome to Banque Misr!",
                    color = colorResource(id = R.color.G900),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 36.sp,
                    textAlign = TextAlign.Center
                )
            }
            Column( verticalArrangement =Arrangement.Top , modifier = modifier.padding(top=15.dp,bottom = 20.dp) ){
                Text(
                    text = "Let’s Complete your Profile",
                    color = colorResource(id = R.color.G700),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 24.sp,
                    textAlign = TextAlign.Center
                )
            }

            Column(
                modifier = Modifier
                    .width(IntrinsicSize.Min)
                    .height(IntrinsicSize.Max)
                    .weight(0.5f)
                //  .padding(start = 16.dp, top = 242.dp)
                , verticalArrangement = Arrangement.spacedBy(10.dp)

            ) {
                Column() {
                    Text(
                        text = "Country",
                        modifier = Modifier.padding(top=5.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        lineHeight = 24.sp,
                        textAlign = TextAlign.Left,
                        color = colorResource(id = R.color.G700)
                    )


                    OutlinedTextField(
                        value = country,
                        onValueChange = { country = it },
                        modifier = Modifier
                            .width(343.dp)
                            .height(54.dp)
                            .background(colorResource(id = R.color.white))
                            .clickable { showBottomSheet = true },
                        placeholder= {
                            Text(
                                text = selectedCountry,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400,
                                lineHeight = 21.sp,
                                color = colorResource(id = R.color.G70),
                                modifier = Modifier.clickable { showBottomSheet = true }
                            )
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.drop_down_1),
                                contentDescription = "Contry Icon",
                                tint = colorResource(id = R.color.G70),
                                modifier = Modifier.rotate(-90f)
                            )
                        }

                    )
                    if (showBottomSheet) {
                        ModalBottomSheet(
                            onDismissRequest = {
                                showBottomSheet = false
                            },
                            sheetState = sheetState

                        ) {
                            CountrieslList(
                                countries = DataSource().getCountriesData(),
                                selectedCountry = selectedCountry ?: "", // Handle null initially
                                onCountrySelect = { newCountry ->
                                    selectedCountry = newCountry
                                    //showBottomSheet = false // Close the sheet after selection
                                }
                            )
                            /*// Sheet content
                            Button(onClick = {
                                scope.launch { sheetState.hide() }.invokeOnCompletion {
                                    if (!sheetState.isVisible) {
                                        showBottomSheet = false
                                    }
                                }
                            }) {
                                Text("Hide bottom sheet")
                            }*/
                        }}
                }


                Column() {
                    Text(
                        text = "Date of Birth",
                        modifier = Modifier.padding(top=5.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        lineHeight = 24.sp,
                        textAlign = TextAlign.Left,
                        color = colorResource(id = R.color.G700)
                    )


                    OutlinedTextField(
                        value = dateOfBirth,
                        onValueChange = { dateOfBirth = it },
                        modifier = Modifier
                            .width(343.dp)
                            .height(54.dp)
                            .background(colorResource(id = R.color.white))
                            .clickable { showDatePicker = true },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedTextColor = colorResource(id = if (dateOfBirth == "DD/MM/YYYY") R.color.G70 else R.color.black)),
                        placeholder= {
                            Text(
                                text = "DD/MM/YYYY",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400,
                                lineHeight = 21.sp,
                                color = colorResource(id = R.color.G70),
                                modifier = Modifier
                                    .width(343.dp)
                                    .height(54.dp)
                                    .background(colorResource(id = R.color.white))
                                    .padding(16.dp)
                                    .clickable { showDatePicker = true },
                            )
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.date_1),
                                contentDescription = "Date Picker",
                                tint = colorResource(id = R.color.G70)
                            )
                        }
                    )
                    if (showDatePicker) {

                        val calendar = Calendar.getInstance()
                        val year = calendar.get(Calendar.YEAR)
                        val month = calendar.get(Calendar.MONTH)
                        val day = calendar.get(Calendar.DAY_OF_MONTH)

                        DatePickerDialog(
                            context,
                            { _, selectedYear, selectedMonth, selectedDay ->
                                dateOfBirth = String.format(
                                    "%02d/%02d/%04d",
                                    selectedDay,
                                    selectedMonth + 1,
                                    selectedYear
                                )
                                showDatePicker = false
                            },
                            year,
                            month,
                            day
                        ).show()
                    }
                }

                Button(
                    //enabled = country.isNotEmpty()&&dateOfBirth.isNotEmpty(),
                    onClick = {
                        val (firstName, lastName) = fullname.split(" ", limit = 2)
                        val register = register(
                            firstName = firstName,
                            lastName = lastName,
                            gender = "",
                            email = email,
                            phoneNumber = "",
                            address = "",
                            nationality = country,
                            nationalNumber = "",
                            dateOfBirth = dateOfBirth,
                            password = password
                        )
                        viewModel.registerUser(register)
                        navController.navigate(SIGNIN)  },
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(343.dp)
                        .height(60.dp)
                        .padding(top = 10.dp)
                    ,
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.marron))
                ) {
                    Text(text ="Continue",color = colorResource(id = R.color.white),
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 21.sp,
                        textAlign = TextAlign.Center )
                }


            }





        }

    }
}







@Composable
fun CountrieslList(countries: List<Country>, selectedCountry: String, onCountrySelect: (String) -> Unit) {
    LazyColumn {
        items(countries) { country ->
            CountrieslistItem(country = country,
                isSelected = country.name == selectedCountry,
                onCountrySelect = onCountrySelect
            )
        }
    }
}

@Composable
fun CountrieslistItem(country: Country, isSelected: Boolean, onCountrySelect: (String) -> Unit, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onCountrySelect(country.name) }
            .background(color = if (isSelected) colorResource(id = R.color.p50) else Color.Transparent) // Red background if selected
    ) {
        Image(
            painter = painterResource(id = country.Flag),
            contentDescription = country.name,
            modifier = modifier
                .width(23.59.dp)
                .height(21.39.dp)
        )

        Text(
            text = country.name,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(top = 5.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            lineHeight = 24.sp,
            color = colorResource(id = R.color.Gray)
        )

        if (isSelected) { // Trailing icon if selected
            Spacer(Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = "Selected",
                tint = colorResource(id = R.color.p300) // Or any color you prefer
            )
        }
    }
}

data class Country( val name: String,
                   @DrawableRes val Flag: Int,
)
class DataSource {
    fun getCountriesData(): List<Country> {
        val countries = mutableListOf<Country>()
        countries.add(
            Country(
                " Egypt",
                R.drawable.egypt
            )
        )
        countries.add(
            Country(
                " United States",
                R.drawable.united_states
            ))
        return countries

    }}





/*
@Preview
@Composable
private fun signUp2Preview() {
    signUp2()
}

*/



