@file:OptIn(ExperimentalFoundationApi::class)

package com.example.alatapp.welcomescreen.presentation.component

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alatapp.ui.theme.AlatAppTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AlatTextField(
    modifier: Modifier = Modifier,
    text: String,
    onSearchDone: () -> Unit,
    onValueChange: () -> Unit
) {

    val bringIntoViewRequester = remember { BringIntoViewRequester() }
    val coroutineScope = rememberCoroutineScope()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(8.dp)
    ) {

        OutlinedTextField(
            modifier = Modifier
                .focusRequester(focusRequester)
                .padding(horizontal = 0.dp),

            value = searchText,
            onValueChange = {
                searchText = it
            },
            placeholder = {
                Text(
                    text = "Search here...",
                    style = TextStyle(fontSize = 14.sp)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {}
            )
        )

        Spacer(modifier = Modifier
            .height(.8.dp)
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .background(color = Color.Black)
            )


    }

}


@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true, heightDp = 400)
fun AlatTextFieldPreview() {
    AlatAppTheme {
        AlatTextField(text = "", onSearchDone = { /*TODO*/ }) {

        }
    }
}
