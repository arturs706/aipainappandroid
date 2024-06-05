package uk.co.aipainapp.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import uk.co.aipainapp.presentation.components.NavComponent.Companion.Nav
import uk.co.aipainapp.presentation.components.SearcgBarComponent
import uk.co.aipainapp.presentation.components.TopBarComponent
import uk.co.aipainapp.presentation.view.theme.WhiteCustom
import uk.co.aipainapp.presentation.view.theme.Salmon


@Composable
fun ConfigScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteCustom)
    ) {
        TopBarComponent.TopBar()
        SearcgBarComponent.SearchBar()
        Spacer(modifier = Modifier.weight(1f))
        Nav(navController = navController)
    }
}
