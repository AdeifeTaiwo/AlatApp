package com.example.alatapp.welcomescreen.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alatapp.R
import com.example.alatapp.ui.theme.AlatAppTheme
import kotlin.math.abs


@Composable
@Preview
fun PreviewCryptoItem() {
    AlatAppTheme {
        AlatGradientBackground()
    }

}

@Composable
fun AlatGradientBackground() {

    BoxWithConstraints(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .height(156.dp)
            .width(400.dp)
            .background(Color(0XFF6B214A))

    ) {

        val width = constraints.maxWidth
        val height = constraints.maxHeight

        val alatCurvePoint1 = Offset(x = 0f, y = height * 0.55f)
        val alatCurvePoint2 = Offset(x = width * 0.3f, y = height * 0.35f)
        val alatCurvePoint3 = Offset(x = width * 0.6f, y = 0.0f)

        val alatCurvedPath = Path().apply {
            moveTo(alatCurvePoint1.x, alatCurvePoint1.y)
            standardQuadFromTo(alatCurvePoint1, alatCurvePoint2)
            standardQuadFromTo(alatCurvePoint2, alatCurvePoint3)
            lineTo(width * 0.6f, 0.0f)
            lineTo(0f, 0f)
            close()
        }

        val alatCurveDeepPoint1 = Offset(x = width * 0.35f, y = height * 1f)
        val alatCurveDeepPoint2 = Offset(x = width * 0.5f, y = height * 0.9f)
        val alatCurveDeepPoint3 = Offset(x = width * 1f - 30f, y = 0f)


        val alatCurvedPath2 = Path().apply {
            moveTo(alatCurveDeepPoint1.x, alatCurveDeepPoint1.y)
            standardQuadFromTo(alatCurveDeepPoint1, alatCurveDeepPoint2)
            standardQuadFromTo(alatCurveDeepPoint2, alatCurveDeepPoint3)
            lineTo(width * 1f - 30f, 0.0f)
            lineTo(width * 1f, 0.0f)
            lineTo(width * 1f, height * 1f)
            close()
        }

        val brush = Brush.linearGradient(
            0.0f to Color(0XFFB2214A),
            500.0f to Color(0XFF6B214A),
            start = Offset.Zero,
            end = Offset.Infinite
        )

        val brush2 = Brush.linearGradient(
            0.0f to Color(0XFFB2214A),
            200.0f to Color(0XFF6B214A),
            start = Offset(x = 200f, y = 0f),
            end = Offset.Infinite
        )

        Canvas(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .fillMaxSize()
        ) {
            drawRect(brush)
            drawPath(
                path = alatCurvedPath,
                color = Color(0XFFB2214A)
            )
            drawPath(
                path = alatCurvedPath2,
                color = Color(0XFF6B214A).copy(alpha = 0.2f)
            )

        }


        Text(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterStart),
            text = "Approve Verifier",
            color = Color.White
        )

        Row(
            modifier = Modifier
                .padding(start = 8.dp, bottom = 16.dp)
                .align(Alignment.BottomStart),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(0.dp)
        ) {

            Text(
                text = "Open",
                color = Color.White
            )
            Icon(
                modifier = Modifier
                    .padding(top = 2.dp)
                    .size(16.dp),
                imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "",
                tint = Color.White
            )
        }
        Image(
            modifier = Modifier.align(Alignment.BottomEnd),
            painter = painterResource(id = R.drawable.users), contentDescription = ""
        )


    }
}

fun Path.standardQuadFromTo(from: Offset, to: Offset) {
    quadraticBezierTo(
        from.x,
        from.y,
        abs(from.x + to.x) / 2f,
        abs(from.y + to.y) / 2f
    )
}
