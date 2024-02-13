package com.example.alatapp.welcomescreen.presentation.animations

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer

fun Modifier.shimmerEffect() = composed {


    val transition = rememberInfiniteTransition(label = "")
    val scale = transition.animateFloat(
        initialValue = 0.7f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000)
        ),
        label = ""
    ).value

    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000),
            repeatMode = RepeatMode.Restart

        ), label = ""
    ).value
    background(color = Color.LightGray.copy(alpha = alpha))
    graphicsLayer(
        scaleX = alpha,
        scaleY = alpha
    )



}


