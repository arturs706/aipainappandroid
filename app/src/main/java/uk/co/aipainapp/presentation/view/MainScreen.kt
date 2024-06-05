package uk.co.aipainapp.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import uk.co.aipainapp.presentation.components.NavComponent.Companion.Nav
import uk.co.aipainapp.presentation.components.SearcgBarComponent.Companion.SearchBar
import uk.co.aipainapp.presentation.components.TopBarComponent.Companion.TopBar
import uk.co.aipainapp.presentation.view.theme.WhiteCustom


@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteCustom)
    ) {
        TopBar()
        SearchBar()
        Spacer(modifier = Modifier.weight(1f))
        Nav(navController = navController)
    }
}

@Preview
@Composable
fun SimpleComposablePreview() {
    val navController = rememberNavController()
    MainScreen(navController)
}