package com.example.alatapp.welcomescreen.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.alatapp.AlatNavHost
import com.example.alatapp.R
import com.example.alatapp.core.AlatScreenRoute
import com.example.alatapp.ui.theme.AlatAppTheme
import com.example.alatapp.welcomescreen.presentation.animations.AlatCustomLoader
import com.example.alatapp.welcomescreen.presentation.component.AlatRedBackgroundButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlatDiscountConfirmationScreen(navController: NavController) {

    var showBottomBar = rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        rememberTopAppBarState()
    )

    showBottomBar.value = when (navBackStackEntry?.destination?.route) {
        AlatScreenRoute.EmptyScreen.route -> false
        else -> true
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0XFFA90836),
                    titleContentColor = Color.Transparent,
                ),
                title = {
                    Text(
                        "Discount Code Confirmation",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                },
                navigationIcon = {

                    IconButton(modifier = Modifier, onClick = { }) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_back_arrow),
                            contentDescription = "Localized description",
                            colorFilter = ColorFilter.tint(color = Color.White)
                        )
                    }
                },
                actions = {
//                    Text(
//                        text = "1/2",
//                        fontSize = 14.sp,
//                        modifier = Modifier.padding(end = 12.dp)
//                    )
                },
                scrollBehavior = scrollBehavior
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Column(modifier = Modifier.verticalScroll(rememberScrollState()).padding(horizontal = 24.dp)) {
                ReusableAlatText(
                    modifier = Modifier.padding(vertical = 14.dp),
                    fontWeight = FontWeight.W700, text = "Transaction Details",
                    fontSize = 14.sp,
                    color = Color(0XFFA90836)
                )

                Divider(
                    modifier = Modifier,
                    thickness = 0.7.dp,
                    color = Color(0XFFC4C4C4)
                )

                Column(modifier = Modifier.padding(top = 24.dp)) {
                    ReusableConfirmationDetailsRow(
                        label = "Transaction Date:",
                        details = "28/04/2022 00:00:00 AM"
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ReusableConfirmationDetailsRow(
                        label = "Transaction Amount:",
                        details = "NGN 200,000.00"
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ReusableConfirmationDetailsRow(
                        label = "Amoount in words:",
                        details = "Two Hundred Thousand\nNaira Only"
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ReusableConfirmationDetailsRow(
                        label = "Reference Number:",
                        details = "384/9388928474892292/05jun2020_09"
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ReusableConfirmationDetailsRow(
                        label = "Transaction Remark:",
                        details = "384/9388928474892292/05jun2020_09TRF_WEMA_0"
                    )
                }

                ReusableAlatText(
                    modifier = Modifier.padding(top = 32.dp, bottom = 18.dp),
                    fontWeight = FontWeight.W700, text = "Sender Details",
                    fontSize = 14.sp,
                    color = Color(0XFFA90836)
                )

                Divider(
                    modifier = Modifier,
                    thickness = 0.7.dp,
                    color = Color(0XFFC4C4C4)
                )

                Column(modifier = Modifier.padding(top = 24.dp)) {
                    ReusableConfirmationDetailsRow(
                        label = "Account Number:",
                        details = "98******46"
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ReusableConfirmationDetailsRow(
                        label = "Account Name:",
                        details = "ChuckwuEmeka Mary Marley"
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ReusableConfirmationDetailsRow(
                        label = "Bank:",
                        details = "Wema Bank"
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                }


                //Alat Reward Details

                ReusableAlatText(
                    modifier = Modifier.padding(top = 32.dp, bottom = 18.dp),
                    fontWeight = FontWeight.W700, text = "Alat Reward Details",
                    fontSize = 14.sp,
                    color = Color(0XFFA90836)
                )

                Divider(
                    modifier = Modifier,
                    thickness = 0.7.dp,
                    color = Color(0XFFC4C4C4)
                )

                Column(modifier = Modifier.padding(top = 24.dp)) {
                    ReusableConfirmationDetailsRow(
                        label = "Code:",
                        details = "HUUV91"
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ReusableConfirmationDetailsRow(
                        label = "Discount:",
                        details = "15%"
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ReusableConfirmationDetailsRow(
                        label = "Deel Type:",
                        details = "10% out of place"
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                }
                Spacer(modifier = Modifier.height(16.dp))
                AlatRedBackgroundButton(
                    modifier = Modifier
                        .padding(vertical = 16.dp),
                    text = "Verify"
                ) {

                }

            }//column


        }//BOX


    }

}

@Composable
fun ReusableConfirmationDetailsRow(
    label: String = "",
    details: String = ""
) {
    Row(modifier = Modifier.fillMaxWidth(.97f)) {
        Text(
            modifier = Modifier.weight(.55f),
            text = label, style = TextStyle(
                fontWeight = FontWeight.W400,
                fontSize = 14.sp,
                color = Color(0XFFA90836)
            )
        )

        Text(
            modifier = Modifier.weight(.5f),
            text = details,
            style = TextStyle(
                fontWeight = FontWeight.W400,
                fontSize = 14.sp,
                color = Color.Black,
            ),
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )

    }
}

@Preview
@Composable
fun PreviewAlatDiscountConfirmationScreen() {
    AlatAppTheme {
        AlatCustomLoader {
            AlatDiscountConfirmationScreen(rememberNavController())
        }
    }
}