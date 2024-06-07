package uk.co.aipainapp.presentation.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import uk.co.aipainapp.R
import uk.co.aipainapp.presentation.components.NavComponent.Companion.Nav
import uk.co.aipainapp.presentation.components.SearcgBarComponent.Companion.SearchBar
import uk.co.aipainapp.presentation.components.TopBarComponent.Companion.TopBar
import uk.co.aipainapp.presentation.view.theme.BlackCustom
import uk.co.aipainapp.presentation.view.theme.Salmon
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
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 34.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text (
                text = "Categories",
            )
            Text (
                text = "See All",
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 34.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .height(160.dp)
                    .weight(1f)
                    .border(BorderStroke(0.5.dp, BlackCustom), shape = RoundedCornerShape(16.dp)),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.symptom),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .wrapContentSize(Alignment.Center)
                            .scale(2.5f)
                            .padding(top = 20.dp)

                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Symptom/Mood\n" +
                                " Tracking ",
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                    )
                }

            }
            Spacer(modifier = Modifier.width(24.dp))
            Column(
                modifier = Modifier
                    .height(160.dp)
                    .weight(1f)
                    .border(BorderStroke(0.5.dp, BlackCustom), shape = RoundedCornerShape(16.dp))
                    .padding(start = 5.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.community),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .wrapContentSize(Alignment.Center)
                            .scale(3.5f)
                            .padding(top = 20.dp)

                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Community Support",
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                    )
                }

            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 34.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .height(160.dp)
                    .weight(1f)
                    .border(BorderStroke(0.5.dp, BlackCustom), shape = RoundedCornerShape(16.dp)),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.meditation),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .wrapContentSize(Alignment.Center)
                            .scale(2.5f)
                            .padding(top = 20.dp)

                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Guided Meditation",
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                    )
                }

            }

            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .height(160.dp)
                    .weight(1f)
                    .border(BorderStroke(0.5.dp, BlackCustom), shape = RoundedCornerShape(16.dp))
                    .padding(start = 5.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.stress),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .wrapContentSize(Alignment.Center)
                            .scale(2.5f)
                            .padding(top = 20.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Stress Assessment",
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                    )
                }

            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .padding(top = 24.dp)
                .background(
                    color = Salmon,
                    shape = RoundedCornerShape(8.dp)

                )
                .height(40.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(0.65f))
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    text = "Talk to Alice",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Image(
                    painter = painterResource(id = R.drawable.microphone),
                    contentDescription = "Microphone",
                    modifier = Modifier
                        .scale(1.5f)
                        .align(Alignment.CenterVertically)
                        .padding(end = 15.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(170.dp)
                    .padding(end = 5.dp)

            ) {
                Text(
                    text = "My Hourly Friends",
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                )
                Column(
                    modifier = Modifier
                        .border(
                            BorderStroke(0.5.dp, BlackCustom),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .fillMaxHeight()
                        .fillMaxWidth(),

                    verticalArrangement = Arrangement.Center
                    ) {
                    Column (
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.chatbot),
                            contentDescription = "Microphone",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .scale(2f)
                        )
                        Spacer(modifier = Modifier.height(0.5.dp))
                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .background(
                                    color = Salmon,
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .padding(vertical = 3.dp, horizontal = 5.dp)

                        ){
                            Text(
                                text = "Chat Now",
                            )
                        }
                    }

                }

            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(170.dp)
                    .padding(horizontal = 5.dp)

            ) {
                Text(
                    text = "Live \nSessions",
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                )
                Column(
                    modifier = Modifier
                        .border(
                            BorderStroke(0.5.dp, BlackCustom),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center


                ) {
                    Image(
                        painter = painterResource(id = R.drawable.healthcare),
                        contentDescription = "Microphone",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .scale(2f)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(170.dp)
                    .padding(start = 5.dp)

            ) {
                Text(
                    text = "Graphs and Trends",
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                )
                Column(
                    modifier = Modifier
                        .border(
                            BorderStroke(0.5.dp, BlackCustom),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.assessment),
                        contentDescription = "Microphone",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .scale(2f)
                    )
                }
            }
        }
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