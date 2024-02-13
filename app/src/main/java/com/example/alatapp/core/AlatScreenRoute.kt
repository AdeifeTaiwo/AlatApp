package com.example.alatapp.core

sealed class AlatScreenRoute(val route: String){
    object HomeProceedScreen: AlatScreenRoute("Home Proceed Screen")
    object HomeProceedScreen2: AlatScreenRoute("Home Proceed Screen 2")
    object WelcomeScreen: AlatScreenRoute("Welcome Screen")
    object EmptyScreen: AlatScreenRoute("Empty Screen ")
}
