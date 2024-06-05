package uk.co.aipainapp.presentation.navigation


// AppNavigation.kt
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.co.aipainapp.domain.model.Screen
import uk.co.aipainapp.presentation.view.HomeScreen
import uk.co.aipainapp.presentation.view.LoginScreen
import uk.co.aipainapp.presentation.view.MainScreen
import uk.co.aipainapp.presentation.view.RegisterScreen
import uk.co.aipainapp.presentation.view.AccountScreen
import uk.co.aipainapp.presentation.view.ConfigScreen
import uk.co.aipainapp.presentation.view.FavouritesScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.AccountScreen.route) {
            AccountScreen(navController = navController)
        }
        composable(route = Screen.ConfigScreen.route) {
            ConfigScreen(navController = navController)
        }
        composable(route = Screen.FavouritesScreen.route) {
            FavouritesScreen(navController = navController)
        }


    }
}