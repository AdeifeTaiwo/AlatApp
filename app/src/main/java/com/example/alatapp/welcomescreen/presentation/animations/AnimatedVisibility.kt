package com.example.alatapp.welcomescreen.presentation.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alatapp.ui.theme.AlatAppTheme


@Composable
fun AnimateVisibility_() {
    var isVisible by remember { mutableStateOf(true) }
    val density = LocalDensity.current
    Column {

        val enabled by remember { mutableStateOf(false) }
        val alpha: Float by animateFloatAsState(
            targetValue = if (enabled) 1f else 0.5f,
            // Configure the animation duration and easing.
            animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing), label = ""
        )

        var animate by remember {
            mutableStateOf(false)
        }


        val size = animateDpAsState(
            targetValue = if (animate) 50.dp else 8.dp, label = "",
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioHighBouncy,
                stiffness = Spring.StiffnessMediumLow
            )
        )



        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVertically(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
            exit = slideOutVertically(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            Surface(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .padding(horizontal = 4.dp),
                color = Color.Green

            ) {
                Column {

                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Surface(
            modifier = Modifier
                .height(100.dp)
                .padding(horizontal = size.value)
                .fillMaxWidth()
                .clip(RoundedCornerShape(size.value))
                .background(color = Color.Blue)
                .clickable {
                    animate = !animate
                },
            color = Color.Blue

        ) {
            Column {

            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewAnimatedVisibility() {
    AlatAppTheme {
        AnimateVisibility_()
    }
}

