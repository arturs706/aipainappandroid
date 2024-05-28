package uk.co.aipainapp.presentation.view

import AuthResultContract
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import org.koin.androidx.compose.get
import uk.co.aipainapp.R
import uk.co.aipainapp.domain.model.Screen
import uk.co.aipainapp.presentation.view.theme.Salmon
import uk.co.aipainapp.presentation.view.theme.WhiteCustom
import uk.co.aipainapp.presentation.viewmodel.FacebookLoginViewModel
import uk.co.aipainapp.presentation.viewmodel.GoogleLoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, googleLoginViewModel: GoogleLoginViewModel = get(), facebookLoginViewModel: FacebookLoginViewModel = get()) {
    val context = LocalContext.current
    val googleSignInOptions = remember {
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
    }
    val googleSignInClient = remember {
        GoogleSignIn.getClient(context, googleSignInOptions)
    }

    val googleLauncher = rememberLauncherForActivityResult(
        contract = AuthResultContract()
    ) { result ->
        googleLoginViewModel.handleGoogleSignInResult(result)
    }

    val username by googleLoginViewModel.username
    val password by googleLoginViewModel.password
    val passwordVisibility by googleLoginViewModel.passwordVisibility


    val callbackManager = remember {
        CallbackManager.Factory.create()
    }

    val fbLauncher = rememberLauncherForActivityResult(
        LoginManager.getInstance().createLogInActivityResultContract(callbackManager)
    ) { result ->
        LoginManager.getInstance().onActivityResult(
            result.resultCode,
            result.data,
            object: FacebookCallback<LoginResult> {
                override fun onSuccess(result: LoginResult) {
                    facebookLoginViewModel.handleLoginResult(result.accessToken)
                }
                override fun onCancel() {
                }
                override fun onError(error: FacebookException) {
                }
            }
        )
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteCustom)
    ) {
        Text(
            text = "Login",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 75.dp)
                .wrapContentSize(Alignment.Center)
                .align(Alignment.CenterHorizontally),
            fontSize = 28.sp
        )
        Image(
            painter = painterResource(id = R.drawable.login1),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .align(Alignment.CenterHorizontally)
                .width(300.dp)
                .height(202.dp)
                .scale(2.8f)
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
                value = username,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, end = 70.dp),
                label = { Text("Email") },
                onValueChange = { googleLoginViewModel.onUsernameChange(it) },
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Salmon,
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Salmon,
                    unfocusedLabelColor = Color.Black
                )
            )
            OutlinedTextField(
                value = password,
                onValueChange = { googleLoginViewModel.onPasswordChange(it) },
                label = { Text("Password") },
                visualTransformation = if (passwordVisibility) PasswordVisualTransformation() else VisualTransformation.None,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, end = 70.dp),
                trailingIcon = {
                    IconButton(
                        onClick = { googleLoginViewModel.togglePasswordVisibility() },
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
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Salmon,
                    unfocusedLabelColor = Color.Black
                ),
            )
            Row(
                modifier = Modifier
                    .padding(top = 18.dp, end = 70.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
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
                colors = ButtonDefaults.buttonColors(Salmon)
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
                verticalAlignment = Alignment.CenterVertically
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
                Text(text = "OR")
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
                            googleLauncher.launch(googleSignInClient.signInIntent)
                        }
                )
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Facebook Login",
                    modifier = Modifier
                        .scale(1f)
                        .padding(start = 33.dp)
                        .clickable {
                            fbLauncher.launch(listOf("email", "public_profile"))
                        }
                )
            }
        }
    }
}
