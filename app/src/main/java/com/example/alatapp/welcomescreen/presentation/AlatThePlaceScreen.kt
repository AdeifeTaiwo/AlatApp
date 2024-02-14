package com.example.alatapp.welcomescreen.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alatapp.R
import com.example.alatapp.ui.theme.AlatAppTheme


@Composable
fun AlatThePlaceScreen() {
    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 21.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)) {
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.avatar), contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }

            Text(text = "Hello, The Place", fontWeight = FontWeight.W600, fontSize = 20.sp)
        }

        Text(
            modifier = Modifier.padding(top = 16.dp),
            color = Color(0XFF808080),
            text = "What would you like to do today?",
            fontWeight = FontWeight.W400,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        repeat(3){
            AlatGradientBackground()
            Spacer(modifier = Modifier.height(24.dp))
        }


    }
}


@Composable
@Preview(showBackground = true)
fun PreviewAlatThePlaceScreen() {
    AlatAppTheme {
        AlatThePlaceScreen()
    }

}
