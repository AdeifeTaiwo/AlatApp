package com.example.alatapp.welcomescreen.presentation.animations

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alatapp.ui.theme.AlatAppTheme


@Composable
fun FlipCardDemo() {
    var flipped by remember { mutableStateOf(false) }
    val rotationZ by animateFloatAsState(
        targetValue = if (flipped) 270f else 0f, label = "",
        animationSpec = tween(durationMillis = 2000)
    )
    val translationX by animateFloatAsState(
        targetValue = if (flipped) 150f else 0f, label = "",
        animationSpec = tween(durationMillis = 2000)
    )

    val scaleX by animateFloatAsState(
        targetValue = if (flipped) 1.2f else 1f, label = "",
        animationSpec = tween(durationMillis = 2000)
    )
    val scaleY by animateFloatAsState(
        targetValue = if (flipped) 1.2f else 1f, label = "",
        animationSpec = tween(durationMillis = 2000)
    )

    AlatCustomLoader {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Card(
                modifier = Modifier
                    .graphicsLayer {

                        cameraDistance = 12f * density
                        shadowElevation = if (flipped) 0f else 30f
                        alpha = if (flipped) 0.1f else 0.1f
                        this.scaleY = scaleX
                        this.scaleX = scaleY

                    }
                    .clickable { flipped = !flipped }
                    .width(300.dp)
                    .height(200.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.DarkGray,
                )
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Hey bro", color = Color.White, fontSize = 32.sp)
                }
            }
        }

    }
}

@Preview()
@Composable
fun PreviewFlippedCard() {
    AlatAppTheme {
        FlipCardDemo()

    }
}