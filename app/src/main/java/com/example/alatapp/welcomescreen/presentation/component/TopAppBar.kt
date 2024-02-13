package com.example.alatapp.welcomescreen.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.ExperimentalLayoutApi

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.alatapp.R
import com.example.alatapp.ui.theme.AlatAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    title: String,
    pageCount: String = "1",
    onClick: () -> Unit
) {

    val ctx = LocalContext.current
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(ctx)
            .decoderFactory(SvgDecoder.Factory())
            .data(R.drawable.icon_back_arrow)
            .size(Size.ORIGINAL) // Set the target size to load the image at.
            .build()
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .padding(
                start = 17.dp,
                end = 24.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

    }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    ScrollContent(PaddingValues(0.dp))

}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(
                    color = Color(0XFFF3E9ED),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        )
        {
            Image(
                painter = painterResource(id = R.drawable.emoji_smile),
                contentDescription = "Localized description"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        ReusableAlatText(fontWeight = FontWeight.W600, text = "Welcome!", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))
        ReusableAlatText(
            fontWeight = FontWeight.W400,
            text = "Kindly Type your phone number here",
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(16.dp))
        ReusableAlatText(fontWeight = FontWeight.W500, text = "Phone Number", fontSize = 14.sp)

        Row() {

        }

        val focusRequester = remember { FocusRequester() }
        var searchText by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(
                modifier = Modifier
                    .weight(.3f)
                    .clickable { }
                    .focusRequester(focusRequester)
                    .padding(horizontal = 0.dp),

                value = searchText,
                onValueChange = {
                    searchText = it
                },
                leadingIcon = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            modifier = Modifier.padding(horizontal = 4.dp),
                            painter = painterResource(id = R.drawable.flag_ngn),
                            contentDescription = ""
                        )
                        Text(text = "+234")
                    }
                },
                trailingIcon = {
                    Row(
                        modifier = Modifier.padding(end = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            modifier = Modifier.padding(horizontal = 4.dp),
                            painter = painterResource(id = R.drawable.ic_caret_down),
                            contentDescription = ""
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,

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
            Spacer(modifier = Modifier.width(10.dp))

            OutlinedTextField(
                modifier = Modifier
                    .weight(.8f)
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

        }
        Spacer(modifier = Modifier.height(120.dp))
        AlatRedBackgroundButton(text = "Proceed") {}
    }


}

@Composable
fun ReusableAlatText(
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 20.sp,
    fontWeight: FontWeight,
    text: String
) {
    Text(
        text = text,
        style = TextStyle(fontWeight = fontWeight, fontSize = fontSize)
    )
}

@Composable
fun AlatFlagWithPhoneNumber(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Column(
        modifier = Modifier.width(60.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        val imageState = rememberAsyncImagePainter(
            model =
            ImageRequest.Builder(LocalContext.current)
                .data("http://image.tmdb.org/t/p/w500/9Rj8l6gElLpRL7Kj17iZhrT5Zuw.jpg")
                .size(Size.ORIGINAL)
                .build()
        ).state


        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
//        //Success Image
//        if (imageState is AsyncImagePainter.State.Success) {
//            Image(
//                painter = imageState.painter,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(6.dp)
//                    .height(250.dp),
//                contentDescription = "",
//                contentScale = ContentScale.Crop
//            )
//        }
//
//        else if(imageState is AsyncImagePainter.State.Error){
//            Icon(painter = painterResource(id = R.drawable.emoji_smile), contentDescription = "")
//        }

            Image(
                modifier = Modifier.padding(end = 2.dp),
                painter = painterResource(id = R.drawable.flag_ngn), contentDescription = ""
            )
            ReusableAlatText(fontWeight = FontWeight.W400, text = "+234")
            Icon(
                modifier = Modifier.padding(start = 2.dp, end = 2.dp),
                painter = painterResource(id = R.drawable.ic_caret_down),
                contentDescription = ""
            )

        }
        Divider(modifier.height(1.dp), thickness = .8.dp, color = Color.Black)
    }
}


@Preview
@Composable
fun PreviewTopAppBar() {
    AlatAppTheme {
        WelcomeScreen(title = "", pageCount = "") {

        }
    }
}