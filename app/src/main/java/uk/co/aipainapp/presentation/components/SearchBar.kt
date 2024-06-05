package uk.co.aipainapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.co.aipainapp.presentation.components.SearcgBarComponent.Companion.SearchBar
import uk.co.aipainapp.presentation.view.theme.BlackCustom
import uk.co.aipainapp.presentation.view.theme.Gray
import uk.co.aipainapp.presentation.view.theme.Salmon
import uk.co.aipainapp.presentation.view.theme.WhiteCustom
import uk.co.aipainapp.presentation.viewmodel.SearchBarViewModel

class SearcgBarComponent {
    companion object {
        @Composable
        fun SearchBar(
            viewModel: SearchBarViewModel = SearchBarViewModel()
        ) {
            var searchText by remember { mutableStateOf("") }
            val isSearching by viewModel.isSearching.collectAsState()
            val countriesList by viewModel.countriesList.collectAsState(initial = emptyList())

            LaunchedEffect(searchText) {
                viewModel.onSearchTextChange(searchText)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .height(70.dp)
                        .fillMaxWidth()
                        .background(color = Salmon)
                        .padding(horizontal = 34.dp, vertical = 16.dp)
                ) {
                    BasicTextField(
                        value = searchText,
                        onValueChange = { newValue ->
                            searchText = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .background(
                                color = WhiteCustom,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 16.dp),
                        singleLine = true,
                        textStyle = TextStyle(
                            color = BlackCustom,
                            fontSize = 16.sp,
                        ),
                        decorationBox = { innerTextField ->
                            Box(
                                contentAlignment = Alignment.CenterStart,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                if (searchText.isEmpty()) {
                                    Text(
                                        text = "Search countries",
                                        color = Gray,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 16.dp)
                                    )
                                }
                                innerTextField()
                            }
                        },
                        cursorBrush = SolidColor(BlackCustom),
                    )
                }

                if (isSearching || searchText.isNotBlank()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(WhiteCustom.copy(alpha = 0.8f))
                            .padding(top = 70.dp)
                    ) {
                        LazyColumn {
                            items(countriesList) { country ->
                                Text(
                                    text = country,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { }
                                        .padding(
                                            start = 8.dp,
                                            top = 4.dp,
                                            end = 8.dp,
                                            bottom = 4.dp
                                        )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchBarComposablePreview() {
    SearchBar()
}
