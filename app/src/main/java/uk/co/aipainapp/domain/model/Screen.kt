package uk.co.aipainapp.domain.model;

sealed class Screen (val route: String){
    object HomeScreen: Screen("home_screen")
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")
    object MainScreen: Screen("main_screen")
    object AccountScreen: Screen("account_screen")
    object ConfigScreen: Screen("config_screen")
    object FavouritesScreen: Screen("favourites_screen")
}
