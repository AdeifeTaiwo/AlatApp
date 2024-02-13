package com.example.alatapp

import android.content.res.Configuration
import android.graphics.Paint.Style
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FoodBank
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Upcoming
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.imageLoader
import com.example.alatapp.core.AlatScreenRoute
import com.example.alatapp.welcomescreen.presentation.component.AlatRedBackgroundButton
import com.example.alatapp.ui.theme.AlatAppTheme
import com.example.alatapp.welcomescreen.presentation.Country
import com.example.alatapp.welcomescreen.presentation.CountryItem
import com.example.alatapp.welcomescreen.presentation.WelcomeScreenState
import com.example.alatapp.welcomescreen.presentation.WelcomeScreenViewModel
import com.example.alatapp.welcomescreen.presentation.animations.AlatCustomLoader
import com.example.alatapp.welcomescreen.presentation.animations.CircularProgressbar3
import com.example.alatapp.welcomescreen.presentation.component.ScrollContent
import com.example.alatapp.welcomescreen.presentation.component.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint
import java.time.format.TextStyle

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlatAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    HomeScreen2()
                }
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun HomeScreen2() {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
            rememberTopAppBarState()
        )
        val navController = rememberNavController()
        var showBottomBar = rememberSaveable { mutableStateOf(true) }
        val navBackStackEntry = navController.currentBackStackEntryAsState().value

        showBottomBar.value = when (navBackStackEntry?.destination?.route) {
            AlatScreenRoute.EmptyScreen.route -> false
            else -> true
        }
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = Color.Transparent,
                    ),
                    title = {
                        Text(
                            "",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        AnimatedVisibility(
                            visible = showBottomBar.value,
                            enter = slideInVertically(
                                animationSpec = TweenSpec(
                                    durationMillis = 5000,
                                    delay = 4
                                )
                            ),
                            exit = slideOutVertically(
                                animationSpec = TweenSpec(durationMillis = 2000, delay = 2)
                            )
                        ) {

                            IconButton(modifier = Modifier, onClick = { }) {
                                Image(
                                    painter = painterResource(id = R.drawable.icon_back_arrow),
                                    contentDescription = "Localized description"
                                )
                            }
                        }
                    },
                    actions = {
                        Text(
                            text = "1/2",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(end = 12.dp)
                        )
                    },
                    scrollBehavior = scrollBehavior
                )
            },

            bottomBar = {
                if (showBottomBar.value)
                    BottomNavigationBar(
                        navHostController = navController,
                        onNavigate = {
                            navController.navigate(it)
                        }
                    )
            },
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                AlatNavHost(
                    innerPadding = innerPadding,
                    navController = navController
                )

            }

        }

    }

    @Composable
    fun BottomNavigationBar(
        navHostController: NavHostController, onNavigate: (route: String) -> Unit
    ) {

        val items = listOf<BottomItem>(
            BottomItem(
                title = "Home",
                icon = Icons.Default.Home,
                route = AlatScreenRoute.HomeProceedScreen.route
            ),
            BottomItem(
                title = "Welcome",
                icon = Icons.Default.Wallet,
                route = AlatScreenRoute.WelcomeScreen.route
            ),
            BottomItem(
                title = "Empty",
                icon = Icons.Default.FoodBank,
                route = AlatScreenRoute.EmptyScreen.route
            )
        )

        var selected = rememberSaveable { mutableIntStateOf(0) }
        Row(
            modifier = Modifier
                .height(60.dp)
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {


            items.forEachIndexed { index, bottomItem ->


                NavigationBarItem(
                    selected = selected.intValue == index,
                    onClick = {
                        selected.intValue = index
                        onNavigate(bottomItem.route)
                    },
                    icon = {
                        Icon(
                            imageVector = bottomItem.icon, contentDescription = "",
                            tint = Color.Red
                        )
                    },


                    )
            }
        }

    }
}

@Composable
fun currentRoute(route: String, navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(route)
}


data class BottomItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)

@Composable
fun AlatNavHost(
    innerPadding: PaddingValues,
    navController: NavHostController,
    startDestination: String = AlatScreenRoute.HomeProceedScreen.route
) {
    NavHost(
        modifier = Modifier
            .padding()
            .fillMaxSize(),
        navController = navController,
        startDestination = startDestination
    ) {

        composable(route = AlatScreenRoute.HomeProceedScreen.route) {
            AlatHomeScreen()
        }

        composable(route = AlatScreenRoute.WelcomeScreen.route) {
            WelcomeScreen(title = "") {}
        }


        composable(route = AlatScreenRoute.EmptyScreen.route) {
            val welcomeScreenViewModel: WelcomeScreenViewModel = hiltViewModel()
            val uiState = welcomeScreenViewModel.countryListState.collectAsState().value
            EmptyScreen(uiState)
        }


    }
}


@Composable
fun EmptyScreen(uiState: WelcomeScreenState) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val items = listOf<Country>(
            Country(countryName = "Nigeria", phoneNumber = "+234")
        )

        Surface(modifier = Modifier.fillMaxSize(), color = Color.White.copy(alpha = 0.2f)) {

            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {

                if (uiState.isLoading) {
                    AlatCustomLoader {}
                }
                if (uiState.countryCodeWithFlagList.isNotEmpty()) {
                    LazyColumn() {
                        items(
                            count = uiState.countryCodeWithFlagList.size,
                        ) {
                            CountryItem(item = uiState.countryCodeWithFlagList[it]) {

                            }
                        }
                    }
                }

                if (uiState.hasError) {
                    Box {
                        Text(text = uiState.errorMessage)
                    }
                }

            }
        }



        Row(modifier = Modifier) {
            Box(modifier = Modifier.fillMaxWidth()) {
                AlatRedBackgroundButton(text = "Proceed") {}
            }
        }


    }
}


@Composable
fun AlatHomeScreen(modifier: Modifier = Modifier) {

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Black)) {
            append("Verify")
        }
        withStyle(SpanStyle(color = Color.Red)) {
            append(" Deals")
        }
    }

    ConstraintLayout(modifier = modifier.fillMaxSize()) {

        val (alatLogo, verifyDealText, illustration, loginButton, getStartedButton) = createRefs()


        Image(
            modifier = modifier
                .wrapContentHeight()
                .padding(top = 0.dp)
                .size(50.dp)
                .constrainAs(alatLogo) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(verifyDealText.top)

                },
            painter = painterResource(id = R.drawable.ic_alat_logo),
            contentDescription = "",
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = annotatedString,
            style = androidx.compose.ui.text.TextStyle(

            ),
            modifier = modifier
                .padding(top = 20.dp)
                .constrainAs(verifyDealText) {
                    top.linkTo(alatLogo.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(illustration.top)
                })

        Image(
            modifier = modifier
                .height(300.dp)
                .fillMaxWidth()
                .constrainAs(illustration) {
                    top.linkTo(verifyDealText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(top = 18.dp, start = 32.dp, end = 32.dp),
            painter = painterResource(id = R.drawable.ic_illustration),
            contentDescription = "",
        )


        OutlinedButton(
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, Color.Red),
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .height(48.dp)
                .constrainAs(loginButton) {

                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(getStartedButton.top)

                },
            onClick = { },
        ) {
            Text(text = "Verify Deal", color = Color.Red)
        }

        AlatRedBackgroundButton(
            modifier = modifier
                .padding(bottom = 20.dp)
                .constrainAs(getStartedButton) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            text = "Get Started"
        )
        { }


    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlatAppTheme {
        AlatHomeScreen()
    }
}