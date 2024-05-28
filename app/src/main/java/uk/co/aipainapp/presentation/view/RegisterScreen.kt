package uk.co.aipainapp.presentation.view


import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uk.co.aipainapp.R
import uk.co.aipainapp.domain.model.Screen
import uk.co.aipainapp.presentation.view.theme.Salmon
import uk.co.aipainapp.presentation.view.theme.WhiteCustom

sealed class RegisterScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    var fullname by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(true) }
    val activity = LocalContext.current as Activity

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteCustom)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 90.dp)
                    .background(color = WhiteCustom)
            ) {
                Text(
                    text = "Register",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 75.dp)
                        .wrapContentSize(Alignment.Center)
                        .align(Alignment.CenterHorizontally),
                    fontSize = 28.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.register),
                    contentDescription = "Register",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                        .align(Alignment.CenterHorizontally)
                        .width(300.dp)
                        .height(202.dp)
                        .scale(2f)
                        .padding(top = 15.dp, start = 15.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 70.dp, start = 70.dp)
                ) {
                    OutlinedTextField(
                        value = fullname,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, end = 70.dp),
                        label = { Text("Full Name") },

                        onValueChange = { fullname = it },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Salmon,
                            unfocusedBorderColor = Black,
                            focusedLabelColor = Salmon,
                            unfocusedLabelColor = Black
                        )

                    )

                    OutlinedTextField(
                        value = dob,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, end = 70.dp),
                        label = { Text("Date of Birth") },

                        onValueChange = { dob = it },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Salmon,
                            unfocusedBorderColor = Black,
                            focusedLabelColor = Salmon,
                            unfocusedLabelColor = Black
                        )

                    )
                    OutlinedTextField(
                        value = gender,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, end = 70.dp),
                        label = { Text("Gender") },

                        onValueChange = { gender = it },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Salmon,
                            unfocusedBorderColor = Black,
                            focusedLabelColor = Salmon,
                            unfocusedLabelColor = Black
                        )

                    )

                    OutlinedTextField(
                        value = email,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, end = 70.dp),
                        label = { Text("Email") },

                        onValueChange = { email = it },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Salmon,
                            unfocusedBorderColor = Black,
                            focusedLabelColor = Salmon,
                            unfocusedLabelColor = Black
                        )

                    )



                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },

                        label = { Text("Password") },
                        visualTransformation = if (passwordVisibility) PasswordVisualTransformation() else VisualTransformation.None,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, end = 70.dp),
                        trailingIcon = {
                            IconButton(
                                onClick = { passwordVisibility = !passwordVisibility },
                                modifier = Modifier.padding(end = 8.dp)
                            ) {
                                Icon(
                                    imageVector = if (passwordVisibility) Icons.Filled.VisibilityOff else Icons.Outlined.Visibility,
                                    contentDescription = if (passwordVisibility) "Hide password" else "Show password",
                                    tint = if (passwordVisibility) Color.Gray else Color.Black
                                )
                            }
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Salmon,
                            unfocusedBorderColor = Black,
                            focusedLabelColor = Salmon,
                            unfocusedLabelColor = Black
                        ),

                        )
                    Row(
                        modifier = Modifier
                            .padding(top = 18.dp, end = 70.dp)
                            .fillMaxWidth(),

                        //center the children vertically
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Text(
                            text = "Forgot Password?",
                            color = Color.Black
                        )
                        ClickableText(
                            text = AnnotatedString("Reset"),
                            modifier = Modifier.padding(start = 10.dp),
                            onClick = {
                                navController.navigate(Screen.HomeScreen.route)
                            },
                        )
                    }
                    Button(
                        onClick = { navController.navigate(Screen.HomeScreen.route) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 18.dp, end = 70.dp)
                            .border(width = 4.dp, color = Salmon, shape = RoundedCornerShape(5.dp))
                            .background(Salmon),

                        colors = ButtonDefaults.buttonColors(
                            Salmon
                        )


                    ) {
                        Text(
                            text = "Login",
                            color = Color.White,
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 18.dp, end = 70.dp)
                            .fillMaxWidth(),

                        //center the children vertically
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Text(
                            text = "Don't have an account?",
                            color = Color.Black
                        )
                        ClickableText(
                            text = AnnotatedString("Sign up"),
                            modifier = Modifier.padding(start = 10.dp),
                            onClick = {
                                navController.navigate(Screen.HomeScreen.route)
                            },
                        )

                    }
                    //draw a horizontal line in between
                    Divider(

                        color = Color.Black,
                        thickness = 0.5.dp,
                        modifier = Modifier
                            .padding(top = 18.dp, end = 70.dp)
                            .fillMaxWidth()
                    )

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 18.dp, end = 70.dp),

                        ) {
                        Text(
                            text = "OR"
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp, end = 70.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = "Google Login",
                            modifier = Modifier
                                .scale(2f)
                                .padding(start = 13.dp)
                                .clickable {
                                }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = "Facebook Login",
                            modifier = Modifier
                                .scale(1f)
                                .padding(start = 33.dp)
                                .clickable {
                                }
                        )
                    }
                }
            }
        }
    }
}




