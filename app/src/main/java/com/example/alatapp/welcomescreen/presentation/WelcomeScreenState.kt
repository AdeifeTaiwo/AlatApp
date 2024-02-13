package com.example.alatapp.welcomescreen.presentation

import com.example.alatapp.welcomescreen.data.remote.CountryCodeAndFlagItem

data class WelcomeScreenState(
    val isLoading: Boolean =  true,
    val countryCodeWithFlagList : List<CountryCodeAndFlagItem> = emptyList(),
    val hasError : Boolean = false,
    val errorMessage: String = ""
)
