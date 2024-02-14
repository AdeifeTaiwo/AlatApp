package com.example.alatapp.welcomescreen.presentation


import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alatapp.ui.theme.AlatAppTheme
import com.example.alatapp.ui.theme.faintRed
import com.example.alatapp.ui.theme.lightRed
import com.example.alatapp.welcomescreen.data.remote.CountryCodeAndFlagItem


@Composable
fun CountryItem(
    item: CountryCodeAndFlagItem,
    isSelected: Boolean = false,
    activeHighlightColor: Color = faintRed,
    activeTextColor: Color = Color.White,
    inActiveTextColor: Color = lightRed,
    onItemClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .graphicsLayer {}
            .height(75.dp)
            .fillMaxWidth()
            .background(color = Color.Transparent)
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .semantics { selected = isSelected },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        border = BorderStroke(1.dp, color = Color.DarkGray),
        elevation = CardDefaults.outlinedCardElevation(
            pressedElevation = 8.dp
        )

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
                    .weight(0.8f),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier
                        .weight(1.0f)
                        .padding(start = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {


                    ReusableAlatText(
                        text = item.name.common,
                        fontWeight = FontWeight.W200,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.width(20.dp))
                    ReusableAlatText(
                        modifier = Modifier.padding(end = 8.dp),
                        text = item.name.official,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }

            }

        }
    }

}


data class Country(
    val countryName: String = "Afghanistan",
    val phoneNumber: String = "08035764468"
)

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
fun PreviewCountry() {
    val items = listOf<Country>(
        Country(countryName = "Nigeria", phoneNumber = "+234")
    )
    AlatAppTheme {
        LazyColumn(modifier = Modifier.fillMaxHeight()) {

            item {

                repeat(20) {
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }

    }
}