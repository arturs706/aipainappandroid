package uk.co.aipainapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import uk.co.aipainapp.R
import uk.co.aipainapp.domain.model.Screen
import uk.co.aipainapp.presentation.components.NavComponent.Companion.Nav
import uk.co.aipainapp.presentation.view.theme.Gray

class NavComponent() {
    companion object {
        @Composable
        fun Nav(navController: NavController) {
            Row(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .background(color = Gray),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home Icon",
                    modifier = Modifier
                        .padding(top = 20.dp, end = 15.dp)
                        .size(36.dp)
                        .clickable {
                            navController.navigate(Screen.MainScreen.route)
                        }

                )
                Image(
                    painter = painterResource(id = R.drawable.favourites),
                    contentDescription = "Favourites Icon",
                    modifier = Modifier
                        .padding(top = 20.dp, start = 15.dp, end = 15.dp)
                        .size(36.dp)
                        .clickable {
                            navController.navigate(Screen.FavouritesScreen.route)
                        }
                )
                Image(
                    painter = painterResource(id = R.drawable.config),
                    contentDescription = "Config Icon",
                    modifier = Modifier
                        .padding(top = 20.dp, start = 15.dp, end = 15.dp)
                        .size(36.dp)
                        .clickable {
                            navController.navigate(Screen.ConfigScreen.route)
                        }
                )
                Image(
                    painter = painterResource(id = R.drawable.account),
                    contentDescription = "Account Icon",
                    modifier = Modifier
                        .padding(top = 20.dp, start = 15.dp)
                        .size(36.dp)
                        .clickable {
                            navController.navigate(Screen.AccountScreen.route)
                        }
                )
            }
        }
    }
}

@Preview
@Composable
fun NavComposablePreview() {
    val navController = rememberNavController()
    Nav(navController)
}