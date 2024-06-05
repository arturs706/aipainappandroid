package uk.co.aipainapp.presentation.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uk.co.aipainapp.R
import uk.co.aipainapp.domain.model.Screen
import uk.co.aipainapp.presentation.view.theme.BlackCustom
import uk.co.aipainapp.presentation.view.theme.Gray
import uk.co.aipainapp.presentation.view.theme.Salmon

sealed class HomeScreenClass
@Composable
fun HomeScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Salmon)
    ){
        Text(
            text = "Welcome",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 75.dp)
                .wrapContentSize(Alignment.Center)
                .align(Alignment.CenterHorizontally),
            fontSize = 40.sp
        )
        Image(
            painter = painterResource(id = R.drawable.imgwelcome),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .align(Alignment.CenterHorizontally)
                .width(300.dp)
                .height(306.dp)
        )
        Text(
            text = "AI pain detector",
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .align(Alignment.CenterHorizontally)
                .padding(top = 15.dp),

            fontSize = 20.sp,
        )

        Row {
            Button(
                onClick = { navController.navigate(Screen.LoginScreen.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(top = 18.dp, start = 32.dp, end = 32.dp)
                    .border(width = 6.dp, color = Salmon, shape = RoundedCornerShape(8.dp))
                    .background(Salmon),
                colors = ButtonDefaults.buttonColors(
                    Gray
                )
            ) {
                Text(
                    text = "Login",
                    color = BlackCustom
                )
            }
        }

        Row {
            Button(
                onClick = { navController.navigate(Screen.RegisterScreen.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(top = 18.dp, start = 32.dp, end = 32.dp)
                    .border(width = 6.dp, color = Salmon)
                    .background(Salmon),
                colors = ButtonDefaults.buttonColors(
                    Gray
                )
            ) {
                Text(
                    text = "Sign Up",
                    color = BlackCustom
                )
            }
        }


    }

}