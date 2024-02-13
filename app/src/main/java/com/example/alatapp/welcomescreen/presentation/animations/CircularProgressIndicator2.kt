package com.example.alatapp.welcomescreen.presentation.animations

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CircularProgressIndicator(
    modifier: Modifier = Modifier,
    initialValue: Int,
    primaryColor: Color,
    secondaryColor: Color,
    minValue: Int = 0,
    maxValue: Int = 0,
    circleRadius: Float,
    onPositionChange:(Int) -> Unit
){
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }
    var positionValue by remember {
        mutableStateOf(initialValue)
    }

    Box {
        Canvas(modifier = Modifier.fillMaxSize() ){
            val width = size.width
            val height = size.height
            val circleThickness = width/30f
            circleCenter = Offset(x = width/2f, y =height/2f)

            //the inner circle
            drawCircle(
                brush = Brush.radialGradient(
                    listOf(primaryColor.copy(0.45f),
                        secondaryColor.copy(0.15f))
                ),
                radius = circleRadius,
                center = circleCenter

            )
            //the inner circle
            drawCircle(
                style = Stroke(
                    width = circleThickness
                ),
                color = secondaryColor,
                radius = circleRadius,
                center = circleCenter
            )

            //sweep angle is how far the progress should be drawn
            drawArc(
                color = primaryColor,
                startAngle = 90f,
                sweepAngle = (360f/maxValue) + positionValue.toFloat(),
                style = Stroke(
                    width = circleThickness,
                    cap = StrokeCap.Round
                ),
                useCenter = false,
                size = Size(
                    width = circleRadius * 2f,
                    height = circleRadius * 2f
                ),
                topLeft = Offset(
                    (width - circleRadius * 2f)/2f,
                    (height - circleRadius *2f)/2f
                )

            )


        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    CircularProgressIndicator(
        modifier = Modifier.size(250.dp)
            .background(Color.DarkGray),
        secondaryColor = Color.Blue,
        initialValue = 67,
        primaryColor = Color.Red,
        circleRadius = 230f,
        onPositionChange = {}
    )
}