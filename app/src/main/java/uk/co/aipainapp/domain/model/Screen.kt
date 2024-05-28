package uk.co.aipainapp.domain.model;

sealed class Screen (val route: String){
    object HomeScreen: Screen("home_screen")
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")
}
