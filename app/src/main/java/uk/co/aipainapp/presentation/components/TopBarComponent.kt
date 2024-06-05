package uk.co.aipainapp.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.aipainapp.presentation.components.SearcgBarComponent.Companion.SearchBar
import uk.co.aipainapp.presentation.components.TopBarComponent.Companion.TopBar
import uk.co.aipainapp.presentation.view.theme.BlackCustom
import uk.co.aipainapp.presentation.view.theme.WhiteCustom
import uk.co.aipainapp.presentation.view.theme.Salmon


class TopBarComponent() {
    companion object {
        @Composable
        fun TopBar() {
            Row(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(color = Salmon),


                ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Bottom),
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .padding(start = 30.dp, top = 18.dp)
                            .background(color = Salmon)
                            .border(width = 6.dp, color = Salmon, shape = RectangleShape),

                        colors = ButtonDefaults.buttonColors(WhiteCustom)
                    ) {
                        Text(

                            text = "Logout",
                            color = BlackCustom,

                            )
                    }
                    Text(
                        text = "hello",
                        modifier = Modifier
                            .align(CenterVertically)
                            .padding(end = 30.dp, top = 18.dp),
                        )

                }
            }
        }
    }
}

@Preview
@Composable
fun TopBarComposablePreview() {
    TopBar()
}