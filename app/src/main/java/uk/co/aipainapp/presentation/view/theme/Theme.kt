package uk.co.aipainapp.presentation.view.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme


private val DarkColorPalette = darkColorScheme(
    primary = Salmon,
)

private val LightColorPalette = lightColorScheme(
    primary = Gray
)

@Composable
fun AipainappTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}