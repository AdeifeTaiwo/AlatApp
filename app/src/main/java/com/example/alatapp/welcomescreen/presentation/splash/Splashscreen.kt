package com.example.alatapp.welcomescreen.presentation.splash

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.alatapp.R
import com.example.alatapp.ui.theme.AlatAppTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onTimeout: () -> Unit, modifier: Modifier = Modifier) {

    val currentOnTimeout by rememberUpdatedState(onTimeout)

    // Create an effect that matches the lifecycle of LandingScreen.
    // If LandingScreen recomposes or onTimeout changes,
    // the delay shouldn't start again.
    LaunchedEffect(Unit) {
        delay(2000)
        currentOnTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    0.0f to Color(0XFFB2214A),
                    500.0f to Color(0XFF6B214A),
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            )
    ) {
        Image(modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.logo), contentDescription = "")
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewSplashScreen(){
    AlatAppTheme {
        SplashScreen({})
    }
}